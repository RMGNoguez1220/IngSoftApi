package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.CarritoCompra;
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
    public ResponseEntity<Object> getAllCarritoCompra() {
        return carritocompraService.getCarritoCompra();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertCarritoCompra(@RequestBody CarritoCompra carritocompra) {
        return this.carritocompraService.carritocompraInsert(carritocompra);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCarritoCompra(@PathVariable Long id, @RequestBody CarritoCompra carritocompra) {
        return this.carritocompraService.carritocompraUpdate(id, carritocompra);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCarritoCompra(@PathVariable Long id) {
        return this.carritocompraService.carritocompraDelete(id);
    }
}
