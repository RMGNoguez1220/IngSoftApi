package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carrito_producto")
public class CarritoProductoController {

    private final Carrito_productoService carritoProductoService;

    public CarritoProductoController(Carrito_productoService carritoProductoService) {
        this.carritoProductoService = carritoProductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCarrito_producto() {
        return carritoProductoService.getCarrito_producto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertCarrito_producto(@RequestBody Carrito_producto carritoProducto) {
        return this.carritoProductoService.insertCarrito_producto(carritoProducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCarrito_producto(@PathVariable Long id, @RequestBody Carrito_producto carritoProducto) {
        return this.carritoProductoService.updateCarrito_producto(id, carritoProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> Carrito_productoDelete(@PathVariable Long id) {
        return this.carritoProductoService.Carrito_productoDelete(id);
    }
}
