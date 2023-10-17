package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.ResenaProductoResponse;
import com.example.ingsoftapi.model.ResenaProducto;
import com.example.ingsoftapi.model.Usuario;
import com.example.ingsoftapi.repository.ResenaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaProductoService {

    private final ResenaProductoRepository resenaproductoRepository;
    private ResenaProductoResponse resenaproductoResponse;

    @Autowired
    public ResenaProductoService(ResenaProductoRepository resenaproductoRepository) {
        this.resenaproductoRepository = resenaproductoRepository;
    }

    public ResponseEntity<Object> getResenaProducto() {
        List<ResenaProducto> resenaproductoList = resenaproductoRepository.findAll();
        if (!resenaproductoList.isEmpty()) {
            resenaproductoResponse = new ResenaProductoResponse(resenaproductoList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(resenaproductoResponse.responseAll(), HttpStatus.OK);
        } else {
            resenaproductoResponse = new ResenaProductoResponse("No hay registros", 400, false);
            return new ResponseEntity<>(resenaproductoResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> resenaproductoInsert(ResenaProducto resenaproducto) {
        this.resenaproductoRepository.save(resenaproducto);
        resenaproductoResponse = new ResenaProductoResponse(resenaproducto, "Se pudo crear el pedido", 200, true);
        return new ResponseEntity<>(resenaproductoResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> resenaproductoUpdate(final Long id, final ResenaProducto resenaproducto) {
        if (resenaproductoRepository.findById(id).isPresent()) {
            ResenaProducto resenaproductoUpdated = resenaproductoRepository.findById(id).get();
            resenaproductoUpdated.setId_usuario(resenaproducto.getId_usuario());
            resenaproductoUpdated.setId_producto(resenaproducto.getId_producto());
            resenaproductoUpdated.setCalificacion(resenaproducto.getCalificacion());
            resenaproductoUpdated.setComentario(resenaproducto.getComentario());
            resenaproductoRepository.save(resenaproductoUpdated);
            resenaproductoResponse = new ResenaProductoResponse(resenaproductoUpdated, "El resena_producto se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(resenaproductoResponse.responseInsert(), HttpStatus.OK);
        } else {
            resenaproductoResponse = new ResenaProductoResponse("El resena_producto no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(resenaproductoResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> resenaproductoDelete(final Long id) {
        if (!this.resenaproductoRepository.findById(id).isEmpty()) {
            this.resenaproductoRepository.deleteById(id);
            resenaproductoResponse = new ResenaProductoResponse("Se ha eliminado la reseña_producto", 200, true);
            return new ResponseEntity<>(resenaproductoResponse.responseInsert(), HttpStatus.OK);
        } else {
            resenaproductoResponse = new ResenaProductoResponse("No se encontró el reseña_producto que quieres borrar ", 400, false);
            return new ResponseEntity<>(resenaproductoResponse.responseInsert(), HttpStatus.OK);
        }
    }

}