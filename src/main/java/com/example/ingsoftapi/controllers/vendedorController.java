package com.example.ingsoftapi.controllers;



import com.example.ingsoftapi.services.vendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vendedor")
public class vendedorController {
    private final vendedorService VendedorService;

    public vendedorController(vendedorService VendedorService) {
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
