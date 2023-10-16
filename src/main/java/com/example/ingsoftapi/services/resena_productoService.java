package com.example.ingsoftapi.services;

import com.example.ingsoftapi.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class resena_productoService {

    private final Resena_productoRepository resenaProductoRepository;
    private Resena_productoResponse resenaProductoResponse;

    @Autowired
    public resena_productoService(Resena_productoRepository resenaProductoRepository) {
        this.resenaProductoRepository = resenaProductoRepository;
    }

    public ResponseEntity<Object> getresena_producto() {
        List<Usuario> usuarioList = resenaProductoRepository.findAll();
        if (!usuarioList.isEmpty()) {
            resenaProductoResponse = new Resena_productoResponse(usuarioList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(resenaProductoResponse.responseAll(), HttpStatus.OK);
        } else {
            resenaProductoResponse = new Resena_productoResponse("No hay registros", 400, false);
            return new ResponseEntity<>(resenaProductoResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> insertResena_producto(Usuario usuario) {
        this.resenaProductoRepository.save(usuario);
        resenaProductoResponse = new Resena_productoResponse(usuario, "Se pudo crear el pedido", 200, true);
        return new ResponseEntity<>(resenaProductoResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateResena_producto(final Long id, final Usuario usuario) {
        if (resenaProductoRepository.findById(id).isPresent()) {
            Usuario usuarioUpdated = resenaProductoRepository.findById(id).get();
            usuarioUpdated.setId_usuario(usuario.getId_usuario());
            usuarioUpdated.setId_producto(usuario.getId_producto());
            usuarioUpdated.setCalificacion(usuario.getCalificacion());
            usuarioUpdated.setComentario(usuario.getComentario());
            resenaProductoRepository.save(usuarioUpdated);
            resenaProductoResponse = new Resena_productoResponse(usuarioUpdated, "El resena_producto se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(resenaProductoResponse.responseInsert(), HttpStatus.OK);
        } else {
            resenaProductoResponse = new Resena_productoResponse("El resena_producto no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(resenaProductoResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> resena_productoDelete(final Long id) {
        if (!this.resenaProductoRepository.findById(id).isEmpty()) {
            this.resenaProductoRepository.deleteById(id);
            resenaProductoResponse = new Resena_productoResponse("Se ha eliminado la reseña_producto", 200, true);
            return new ResponseEntity<>(resenaProductoResponse.responseInsert(), HttpStatus.OK);
        } else {
            resenaProductoResponse = new Resena_productoResponse("No se encontró el reseña_producto que quieres borrar ", 400, false);
            return new ResponseEntity<>(resenaProductoResponse.responseInsert(), HttpStatus.OK);
        }
    }

}
