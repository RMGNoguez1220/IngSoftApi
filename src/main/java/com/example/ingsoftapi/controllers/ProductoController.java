package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Producto;
import com.example.ingsoftapi.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllProducto() {
        logg.info("Solicitando la lista de todos los productos");
        return productoService.getProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertProducto(@RequestBody Producto producto) {
        logg.info("Registrando un nuevo producto: {}", producto);
        return this.productoService.productoInsert(producto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        logg.info("Actualizando información del producto con ID: {} - {}", id, producto);
        return this.productoService.productoUpdate(id, producto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable Long id) {
        logg.info("Eliminando el producto con ID: {}", id);
        return this.productoService.productoDelete(id);
    }
}
