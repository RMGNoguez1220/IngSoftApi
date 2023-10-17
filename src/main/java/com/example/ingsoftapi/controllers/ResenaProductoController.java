package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.ResenaProducto;
import com.example.ingsoftapi.services.ResenaProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/resena_producto")
public class ResenaProductoController {

    private final ResenaProductoService resenaproductoService;

    public ResenaProductoController(ResenaProductoService resenaproductoService) {
        this.resenaproductoService = resenaproductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllResenaProducto() {
        return resenaproductoService.getResenaProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertResenaProducto(@RequestBody ResenaProducto resenaproducto) {
        return this.resenaproductoService.resenaproductoInsert(resenaproducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateResenaProducto(@PathVariable Long id, @RequestBody ResenaProducto resenaproducto) {
        return this.resenaproductoService.resenaproductoUpdate(id, resenaproducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteResenaProducto(@PathVariable Long id) {
        return this.resenaproductoService.resenaproductoDelete(id);
    }
}
