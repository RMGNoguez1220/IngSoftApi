package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Producto;
import com.example.ingsoftapi.services.ProductoService;
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
        return this.productoService.productoInsert(producto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return this.productoService.productoUpdate(id, producto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Long id) {
        return this.productoService.productoDelete(id);
    }
}
