package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.OrdenCompraResponse;
import com.example.ingsoftapi.model.OrdenCompra;
import com.example.ingsoftapi.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraService {

    private final OrdenCompraRepository ordencompraRepository;
    private OrdenCompraResponse ordencompraResponse;

    @Autowired
    public OrdenCompraService(OrdenCompraRepository ordencompraRepository) {
        this.ordencompraRepository = ordencompraRepository;
    }

    public ResponseEntity<Object> getOrdenCompra() {
        List<OrdenCompra> ordencompraList = ordencompraRepository.findAll();
        if (!ordencompraList.isEmpty()) {
            ordencompraResponse = new OrdenCompraResponse(ordencompraList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(ordencompraResponse.responseAll(), HttpStatus.OK);
        } else {
            ordencompraResponse = new OrdenCompraResponse("No hay registros", 400, false);
            return new ResponseEntity<>(ordencompraResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> ordencompraInsert(OrdenCompra ordencompra) {
        this.ordencompraRepository.save(ordencompra);
        ordencompraResponse = new OrdenCompraResponse(ordencompra, "Se pudo crear la orden de compra", 200, true);
        return new ResponseEntity<>(ordencompraResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> ordencompraUpdate(final Long id, final OrdenCompra ordencompra) {
        if (ordencompraRepository.findById(id).isPresent()) {
            OrdenCompra ordencompraUpdated = ordencompraRepository.findById(id).get();
            ordencompraUpdated.setFecha_hora(ordencompra.getFecha_hora());
            ordencompraUpdated.setEstado(ordencompra.getEstado());
            ordencompraUpdated.setDireccion_envio(ordencompra.getDireccion_envio());
            ordencompraUpdated.setMetodo_pago(ordencompra.getMetodo_pago());
            ordencompraUpdated.setMonto_total(ordencompra.getMonto_total());
            ordencompraRepository.save(ordencompraUpdated);
            ordencompraResponse = new OrdenCompraResponse(ordencompraUpdated, "La orden de compra se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(ordencompraResponse.responseInsert(), HttpStatus.OK);
        } else {
            ordencompraResponse = new OrdenCompraResponse("La orden de compra no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(ordencompraResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> ordencompraDelete(final Long id) {
        if (!this.ordencompraRepository.findById(id).isEmpty()) {
            this.ordencompraRepository.deleteById(id);
            ordencompraResponse = new OrdenCompraResponse("Se ha eliminado la orden de compra", 200, true);
            return new ResponseEntity<>(ordencompraResponse.responseInsert(), HttpStatus.OK);
        } else {
            ordencompraResponse = new OrdenCompraResponse("No se encontró la orden de compra que quieres borrar ", 400, false);
            return new ResponseEntity<>(ordencompraResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
