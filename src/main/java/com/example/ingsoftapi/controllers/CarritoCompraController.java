package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carrito_compra")
public class CarritoCompraController {


    private final Carrito_compraService carritoCompraService;

    public CarritoCompraController(Carrito_compraService carritoCompraService) {
        this.carritoCompraService = carritoCompraService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllComprador() {
        return carritoCompraService.getCarritoCompra();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertComprador(@RequestBody CarritoCompra carritoCompra) {
        return this.carritoCompraService.insertCarritoCompra(carritoCompra);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateComprador(@PathVariable Long id, @RequestBody CarritoCompra carritoCompra) {
        return this.carritoCompraService.updateCarritoCompra(id, carritoCompra);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> CompradorDelete(@PathVariable Long id) {
        return this.carritoCompraService.CarritoCompraDelete(id);
    }
}
