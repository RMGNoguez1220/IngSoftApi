package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Comprador;
import com.example.ingsoftapi.services.CompradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comprador")
public class CompradorController {

    private final CompradorService compradorService;

    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllComprador() {
        return compradorService.getComprador();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertComprador(@RequestBody Comprador comprador) {
        return this.compradorService.compradorInsert(comprador);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateComprador(@PathVariable Long id, @RequestBody Comprador comprador) {
        return this.compradorService.compradorUpdate(id, comprador);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteComprador(@PathVariable Long id) {
        return this.compradorService.compradorDelete(id);
    }
}
