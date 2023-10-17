package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.OrdenCompra;
import com.example.ingsoftapi.services.OrdenCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Orden_compra")
public class OrdenCompraController {
    private final OrdenCompraService ordencompraService;

    public OrdenCompraController(OrdenCompraService ordencompraService) {
        this.ordencompraService = ordencompraService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllOrdenCompra() {
        return ordencompraService.getOrdenCompra();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertOrdenCompra(@RequestBody OrdenCompra ordencompra) {
        return this.ordencompraService.ordencompraInsert(ordencompra);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateOrdenCompra(@PathVariable Long id, @RequestBody OrdenCompra ordencompra) {
        return this.ordencompraService.ordencompraUpdate(id, ordencompra);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteOrdenCompra(@PathVariable Long id) {
        return this.ordencompraService.ordencompraDelete(id);
    }
}
