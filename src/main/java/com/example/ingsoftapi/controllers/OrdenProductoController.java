package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.OrdenProducto;
import com.example.ingsoftapi.services.OrdenProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/orden_producto")
public class OrdenProductoController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);
    private final OrdenProductoService ordenproductoService;

    public OrdenProductoController(OrdenProductoService ordenproductoService) {
        this.ordenproductoService = ordenproductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllOrdenProducto() {
        logg.info("Solicitando la lista de todas las ordenes de productos");
        return ordenproductoService.getOrdenProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertOrdenProducto(@RequestBody OrdenProducto ordenproducto) {
        logg.info("Registrando una nueva orden de producto: {}", ordenproducto);
        return this.ordenproductoService.ordenproductoInsert(ordenproducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateOrdenProducto(@PathVariable Long id, @RequestBody OrdenProducto ordenProducto) {
        logg.info("Actualizando información de la orden de producto con ID: {} - {}", id, ordenProducto);
        return this.ordenproductoService.ordenproductoUpdate(id, ordenProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteOrdenProducto(@PathVariable Long id) {
        logg.info("Eliminando la orden de producto con ID: {}", id);
        return this.ordenproductoService.ordenproductoDelete(id);
    }
}
