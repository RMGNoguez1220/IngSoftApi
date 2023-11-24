package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Vendedor;
import com.example.ingsoftapi.services.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/vendedor")
public class VendedorController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);

    private final VendedorService vendedorservice;

    public VendedorController(com.example.ingsoftapi.services.VendedorService vendedorservice) {
        this.vendedorservice = vendedorservice;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllVendedor() {
        logg.info("Solicitando la lista de todos los vendedores");
        return vendedorservice.getVendedor();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertVendedor(@RequestBody Vendedor vendedor) {
        logg.info("Registrando un nuevo vendedor: {}", vendedor);
        return this.vendedorservice.vendedorInsert(vendedor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        logg.info("Actualizando información del vendedor con ID: {} - {}", id, vendedor);
        return this.vendedorservice.vendedorUpdate(id, vendedor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVendedor(@PathVariable Long id) {
        logg.info("Eliminando el vendedor con ID: {}", id);
        return this.vendedorservice.vendedorDelete(id);
    }


}
