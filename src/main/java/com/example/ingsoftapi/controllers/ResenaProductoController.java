package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/resena_producto")
public class ResenaProductoController {

    private final com.example.ingsoftapi.services.ResenaProductoService ResenaProductoService;

    public ResenaProductoController(Resena_productoService resenaProductoService) {
        this.ResenaProductoService = resenaProductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllResena_producto() {
        return ResenaProductoService.getresena_producto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertResena_producto(@RequestBody Resena_producto resenaProducto) {
        return this.ResenaProductoService.insertResena_producto(resenaProducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateResena_producto(@PathVariable Long id, @RequestBody Resena_producto resenaProducto) {
        return this.ResenaProductoService.updateResena_producto(id, resenaProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> resena_productoDelete(@PathVariable Long id) {
        return this.ResenaProductoService.resena_productoDelete(id);
    }
}
