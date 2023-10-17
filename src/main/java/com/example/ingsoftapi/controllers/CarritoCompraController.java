package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.services.CarritoCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carrito_compra")
public class CarritoCompraController {


    private final CarritoCompraService carritocompraService;

    public CarritoCompraController(CarritoCompraService carritocompraService) {
        this.carritocompraService = carritocompraService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllComprador() {
        return carritocompraService.getCarritoCompra();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertComprador(@RequestBody CarritoCompra carritoCompra) {
        return this.carritocompraService.insertCarritoCompra(carritoCompra);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateComprador(@PathVariable Long id, @RequestBody CarritoCompra carritoCompra) {
        return this.carritocompraService.updateCarritoCompra(id, carritoCompra);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> CompradorDelete(@PathVariable Long id) {
        return this.carritocompraService.CarritoCompraDelete(id);
    }
}
