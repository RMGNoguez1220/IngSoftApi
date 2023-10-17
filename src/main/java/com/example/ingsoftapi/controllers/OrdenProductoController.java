package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orden_producto")
public class OrdenProductoController {

    private final Orden_productoService ordenProductoService;

    public OrdenProductoController(Orden_productoService ordenProductoService) {
        this.ordenProductoService = ordenProductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllOrden_producto() {
        return ordenProductoService.getOrden_producto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertOrden_producto(@RequestBody Orden_producto ordenProducto) {
        return this.ordenProductoService.insertCarritoCompra(ordenProducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateOrden_producto(@PathVariable Long id, @RequestBody Orden_producto ordenProducto) {
        return this.ordenProductoService.updateCarritoCompra(id, ordenProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> Orden_productoDelete(@PathVariable Long id) {
        return this.ordenProductoService.Orden_productoDelete(id);
    }
}
