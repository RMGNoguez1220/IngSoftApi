package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.OrdenProducto;
import com.example.ingsoftapi.services.OrdenProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orden_producto")
public class OrdenProductoController {

    private final OrdenProductoService ordenproductoService;

    public OrdenProductoController(OrdenProductoService ordenproductoService) {
        this.ordenproductoService = ordenproductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllOrdenProducto() {
        return ordenproductoService.getOrdenProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertOrdenProducto(@RequestBody OrdenProducto ordenproducto) {
        return this.ordenproductoService.ordenproductoInsert(ordenproducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateOrdenProducto(@PathVariable Long id, @RequestBody OrdenProducto ordenProducto) {
        return this.ordenproductoService.ordenproductoUpdate(id, ordenProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteOrdenProducto(@PathVariable Long id) {
        return this.ordenproductoService.ordenproductoDelete(id);
    }
}
