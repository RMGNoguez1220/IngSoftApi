package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.PedidoResponse;
import com.example.ingsoftapi.model.Pedido;
import com.example.ingsoftapi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private PedidoResponse pedidoResponse;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public ResponseEntity<Object> getPedido() {
        List<Pedido> pedidoList = pedidoRepository.findAll();
        if (!pedidoList.isEmpty()) {
            pedidoResponse = new PedidoResponse(pedidoList, "Pedidos", 200, true);
            return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No hay pedidos", 400, false);
            return new ResponseEntity<>(pedidoResponse.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> insertPedido(final Pedido pedido) {
        this.pedidoRepository.save(pedido);
        pedidoResponse = new PedidoResponse(pedido, "Creación correcta", 200, true);
        return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
    }

    public ResponseEntity<Object> deletePedido(final Long id) {
        if (!this.pedidoRepository.findById(id).isEmpty()) {
            this.pedidoRepository.deleteById(id);
            pedidoResponse = new PedidoResponse("Eliminacion correcta: " + id, 200, true);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("Registro no existente " + id, 400, false);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getOnePedido(final Long id) {
        if (pedidoRepository.findById(id).isPresent()) {
            Pedido pedido = pedidoRepository.findById(id).get();
            pedidoResponse = new PedidoResponse(pedido, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No existe el detalle de la venta con el ID: " + id, 400, false);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        }
    }
    public ResponseEntity<Object> updatePedido(final Long id, final Pedido pedido) {
        if (pedidoRepository.findById(id).isPresent()) {
            Pedido existingPedido = pedidoRepository.findById(id).get();
            existingPedido.setFecha_pedido(pedido.getFecha_pedido());
            existingPedido.setTienda_id(pedido.getTienda_id());
            existingPedido.setUsuario_id(pedido.getUsuario_id());
            existingPedido.setVenta_id(pedido.getVenta_id());
            pedidoRepository.save(existingPedido);
            pedidoResponse = new PedidoResponse(existingPedido, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        } else {
            pedidoResponse = new PedidoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(pedidoResponse.response(), HttpStatus.OK);
        }
    }
}
