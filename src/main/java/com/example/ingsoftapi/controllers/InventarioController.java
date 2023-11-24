package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Inventario;
import com.example.ingsoftapi.services.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/inventario")
public class InventarioController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllInventario() {
        logg.info("Solicitando la lista de todos los inventarios");
        return inventarioService.getInventario();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertInventario(@RequestBody Inventario inventario) {
        logg.info("Registrando un nuevo inventario: {}", inventario);
        return this.inventarioService.inventarioInsert(inventario);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateInventario(@PathVariable Long id, @RequestBody Inventario inventario) {
        logg.info("Actualizando información del inventario con ID: {} - {}", id, inventario);
        return this.inventarioService.inventarioUpdate(id, inventario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> InventarioDelete(@PathVariable Long id) {
        logg.info("Eliminando el inventario con ID: {}", id);
        return this.inventarioService.inventarioDelete(id);
    }

}
