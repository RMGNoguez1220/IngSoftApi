package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/producto")
public class productoController {
    private final ProductoService productoService;

    public productoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllProduct() {
        return productoService.getProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertProduct(@RequestBody Producto producto) {
        return this.productoService.insertProducto(producto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Producto producto) {
        return this.productoService.updateProduct(id, producto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> ProductDelete(@PathVariable Long id) {
        return this.productoService.ProductoDelete(id);
    }
}
