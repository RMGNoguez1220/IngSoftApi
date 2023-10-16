package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comprador")
public class compradorController {

    private final CompradorService compradorService;

    public compradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllComprador() {
        return compradorService.getComprador();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertComprador(@RequestBody Comprador comprador) {
        return this.compradorService.insertComprador(comprador);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateComprador(@PathVariable Long id, @RequestBody Comprador comprador) {
        return this.compradorService.updateComprador(id, comprador);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> CompradorDelete(@PathVariable Long id) {
        return this.compradorService.CompradorDelete(id);
    }
}
