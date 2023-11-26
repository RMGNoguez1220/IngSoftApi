package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.InventarioResponse;
import com.example.ingsoftapi.model.Inventario;
import com.example.ingsoftapi.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.ingsoftapi.repository.InventarioRepository;

import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;
    private InventarioResponse inventarioResponse;

    @Autowired
    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public ResponseEntity<Object> getInventario() {
        List<Inventario> inventarioList = inventarioRepository.findAll();
        if (!inventarioList.isEmpty()) {
            inventarioResponse = new InventarioResponse(inventarioList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(inventarioResponse.responseAll(), HttpStatus.OK);
        } else {
            inventarioResponse = new InventarioResponse("No hay registros", 400, false);
            return new ResponseEntity<>(inventarioResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> inventarioInsert(Inventario inventario) {
        this.inventarioRepository.save(inventario);
        inventarioResponse = new InventarioResponse(inventario, "Se pudo crear el pedido", 200, true);
        return new ResponseEntity<>(inventarioResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> inventarioUpdate(final Long id, final Inventario inventario) {
        if (inventarioRepository.findById(id).isPresent()) {
            Inventario inventarioUpdated = inventarioRepository.findById(id).get();
            inventarioUpdated.setId_producto(inventario.getId_producto());
            inventarioUpdated.setId_vendedor(inventario.getId_vendedor());
            inventarioUpdated.setCantidad_stock(inventario.getCantidad_stock());
            inventarioRepository.save(inventarioUpdated);
            inventarioResponse = new InventarioResponse(inventarioUpdated, "El inventario se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(inventarioResponse.responseInsert(), HttpStatus.OK);
        } else {
            inventarioResponse = new InventarioResponse("El inventario no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(inventarioResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> inventarioDelete(final Long id) {
        if (!this.inventarioRepository.findById(id).isEmpty()) {
            this.inventarioRepository.deleteById(id);
            inventarioResponse = new InventarioResponse("Se ha eliminado el inventario", 200, true);
            return new ResponseEntity<>(inventarioResponse.responseInsert(), HttpStatus.OK);
        } else {
            inventarioResponse = new InventarioResponse("No se encontró el inventario que quieres borrar ", 400, false);
            return new ResponseEntity<>(inventarioResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
