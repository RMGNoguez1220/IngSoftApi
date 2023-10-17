package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.OrdenProductoResponse;
import com.example.ingsoftapi.model.OrdenProducto;
import com.example.ingsoftapi.repository.OrdenProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenProductoService {

    private final OrdenProductoRepository ordenproductoRepository;
    private OrdenProductoResponse ordenproductoResponse;

    @Autowired
    public OrdenProductoService(OrdenProductoRepository ordenproductoRepository) {
        this.ordenproductoRepository = ordenproductoRepository;
    }

    public ResponseEntity<Object> getOrdenProducto() {
        List<OrdenProducto> ordenproductoList = ordenproductoRepository.findAll();
        if (!ordenproductoList.isEmpty()) {
            ordenproductoResponse = new OrdenProductoResponse(ordenproductoList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(ordenproductoResponse.responseAll(), HttpStatus.OK);
        } else {
            ordenproductoResponse = new OrdenProductoResponse("No hay registros", 400, false);
            return new ResponseEntity<>(ordenproductoResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> ordenproductoInsert(OrdenProducto ordenproducto) {
        this.ordenproductoRepository.save(ordenproducto);
        ordenproductoResponse = new OrdenProductoResponse(ordenproducto, "Se pudo crear la orden de producto", 200, true);
        return new ResponseEntity<>(ordenproductoResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> ordenproductoUpdate(final Long id, final OrdenProducto ordenproducto) {
        if (ordenproductoRepository.findById(id).isPresent()) {
            OrdenProducto ordenproductoUpdated = ordenproductoRepository.findById(id).get();
            ordenproductoUpdated.setCantidad(ordenproducto.getCantidad());
            ordenproductoRepository.save(ordenproductoUpdated);
            ordenproductoResponse = new OrdenProductoResponse(ordenproductoUpdated, "La orden de producto se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(ordenproductoResponse.responseInsert(), HttpStatus.OK);
        } else {
            ordenproductoResponse = new OrdenProductoResponse("La orden de producto no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(ordenproductoResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> ordenproductoDelete(final Long id) {
        if (!this.ordenproductoRepository.findById(id).isEmpty()) {
            this.ordenproductoRepository.deleteById(id);
            ordenproductoResponse = new OrdenProductoResponse("Se ha eliminado la orden de producto", 200, true);
            return new ResponseEntity<>(ordenproductoResponse.responseInsert(), HttpStatus.OK);
        } else {
            ordenproductoResponse = new OrdenProductoResponse("No se encontró la orden de producto que quieres borrar ", 400, false);
            return new ResponseEntity<>(ordenproductoResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
