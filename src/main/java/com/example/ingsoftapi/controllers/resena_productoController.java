package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/resena_producto")
public class resena_productoController {

    private final Resena_productoService resenaProductoService;

    public resena_productoController(Resena_productoService resenaProductoService) {
        this.resenaProductoService = resenaProductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllResena_producto() {
        return resenaProductoService.getResena_producto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertResena_producto(@RequestBody Resena_producto resenaProducto) {
        return this.resenaProductoService.insertCarritoCompra(resenaProducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateResena_producto(@PathVariable Long id, @RequestBody Resena_producto resenaProducto) {
        return this.resenaProductoService.updateResena_producto(id, resenaProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> Resena_productoDelete(@PathVariable Long id) {
        return this.resenaProductoService.Resena_productoDelete(id);
    }
}
