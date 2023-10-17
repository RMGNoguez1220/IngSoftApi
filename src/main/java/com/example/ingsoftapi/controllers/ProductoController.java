package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllProducto() {
        return productoService.getProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertProducto(@RequestBody Producto producto) {
        return this.productoService.insertProducto(producto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return this.productoService.updateProducto(id, producto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> ProductoDelete(@PathVariable Long id) {
        return this.productoService.ProductoDelete(id);
    }
}
