package com.example.ingsoftapi.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vendedor")
public class VendedorController {
    private final com.example.ingsoftapi.services.VendedorService VendedorService;

    public VendedorController(com.example.ingsoftapi.services.VendedorService VendedorService) {
        this.VendedorService = VendedorService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllVendedor() {
        return VendedorService.getVendedor();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertVendedor(@RequestBody Vendedor vendedor) {
        return this.VendedorService.insertVendedor(vendedor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        return this.VendedorService.updateVendedor(id, vendedor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> VendedorDelete(@PathVariable Long id) {
        return this.VendedorService.VendedorDelete(id);
    }


}
