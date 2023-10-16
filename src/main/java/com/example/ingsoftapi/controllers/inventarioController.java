package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.services.inventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/inventario")
public class inventarioController {

    private final inventarioService inventarioService;

    public inventarioController(inventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllInventario() {
        return inventarioService.getInventario();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertInventario(@RequestBody Inventario inventario) {
        return this.inventarioService.insertInventario(inventario);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateInventario(@PathVariable Long id, @RequestBody Inventario inventario) {
        return this.inventarioService.updateInventario(id, inventario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> InventarioDelete(@PathVariable Long id) {
        return this.inventarioService.inventarioDelete(id);
    }

}
