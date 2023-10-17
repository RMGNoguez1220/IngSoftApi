package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Vendedor;
import com.example.ingsoftapi.services.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vendedor")
public class VendedorController {
    private final VendedorService vendedorservice;

    public VendedorController(com.example.ingsoftapi.services.VendedorService vendedorservice) {
        this.vendedorservice = vendedorservice;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllVendedor() {
        return vendedorservice.getVendedor();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertVendedor(@RequestBody Vendedor vendedor) {
        return this.vendedorservice.vendedorInsert(vendedor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        return this.vendedorservice.vendedorUpdate(id, vendedor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVendedor(@PathVariable Long id) {
        return this.vendedorservice.vendedorDelete(id);
    }


}
