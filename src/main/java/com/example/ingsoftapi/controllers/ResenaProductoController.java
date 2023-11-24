package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.ResenaProducto;
import com.example.ingsoftapi.services.ResenaProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/resena_producto")
public class ResenaProductoController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);

    private final ResenaProductoService resenaproductoService;

    public ResenaProductoController(ResenaProductoService resenaproductoService) {
        this.resenaproductoService = resenaproductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllResenaProducto() {
        logg.info("Solicitando la lista de todas las reseñas de productos");
        return resenaproductoService.getResenaProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertResenaProducto(@RequestBody ResenaProducto resenaproducto) {
        logg.info("Registrando una nueva reseña de producto: {}", resenaproducto);
        return this.resenaproductoService.resenaproductoInsert(resenaproducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateResenaProducto(@PathVariable Long id, @RequestBody ResenaProducto resenaproducto) {
        logg.info("Actualizando información de la reseña del producto con ID: {} - {}", id, resenaproducto);
        return this.resenaproductoService.resenaproductoUpdate(id, resenaproducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteResenaProducto(@PathVariable Long id) {
        logg.info("Eliminando la reseña del producto con ID: {}", id);
        return this.resenaproductoService.resenaproductoDelete(id);
    }
}
