package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.OrdenCompra;
import com.example.ingsoftapi.services.OrdenCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/Orden_compra")
public class OrdenCompraController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);
    private final OrdenCompraService ordencompraService;

    public OrdenCompraController(OrdenCompraService ordencompraService) {
        this.ordencompraService = ordencompraService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllOrdenCompra() {
        logg.info("Solicitando la lista de todas las ordenes de compra");
        return ordencompraService.getOrdenCompra();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertOrdenCompra(@RequestBody OrdenCompra ordencompra) {
        logg.info("Registrando una nueva orden de compra: {}", ordencompra);
        return this.ordencompraService.ordencompraInsert(ordencompra);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateOrdenCompra(@PathVariable Long id, @RequestBody OrdenCompra ordencompra) {
        logg.info("Actualizando información de la orden de compra con ID: {} - {}", id, ordencompra);
        return this.ordencompraService.ordencompraUpdate(id, ordencompra);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteOrdenCompra(@PathVariable Long id) {
        logg.info("Eliminando la orden de compra con ID: {}", id);
        return this.ordencompraService.ordencompraDelete(id);
    }
}
