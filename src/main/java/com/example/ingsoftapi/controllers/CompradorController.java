package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Comprador;
import com.example.ingsoftapi.services.CompradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/comprador")
public class CompradorController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);

    private final CompradorService compradorService;

    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllComprador() {
        logg.info("Solicitando la lista de todos los compradores");
        return compradorService.getComprador();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertComprador(@RequestBody Comprador comprador) {
        logg.info("Registrando un nuevo comprador: {}", comprador);
        return this.compradorService.compradorInsert(comprador);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateComprador(@PathVariable Long id, @RequestBody Comprador comprador) {
        logg.info("Actualizando información del comprador con ID: {} - {}", id, comprador);
        return this.compradorService.compradorUpdate(id, comprador);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteComprador(@PathVariable Long id) {
        logg.info("Eliminando el comprador con ID: {}", id);
        return this.compradorService.compradorDelete(id);
    }
}
