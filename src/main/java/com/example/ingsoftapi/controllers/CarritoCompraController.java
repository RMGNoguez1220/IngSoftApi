package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.CarritoCompra;
import com.example.ingsoftapi.services.CarritoCompraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carrito_compra")
public class CarritoCompraController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);

    private final CarritoCompraService carritocompraService;

    public CarritoCompraController(CarritoCompraService carritocompraService) {
        this.carritocompraService = carritocompraService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCarritoCompra() {
        logg.info("Solicitando todos los carritos de compra");
        return carritocompraService.getCarritoCompra();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertCarritoCompra(@RequestBody CarritoCompra carritocompra) {
        logg.info("Insertando un nuevo carrito de compra: {}", carritocompra);
        return this.carritocompraService.carritocompraInsert(carritocompra);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCarritoCompra(@PathVariable Long id, @RequestBody CarritoCompra carritocompra) {
        logg.info("Actualizando carrito de compra con ID: {} - {}", id, carritocompra);
        return this.carritocompraService.carritocompraUpdate(id, carritocompra);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCarritoCompra(@PathVariable Long id) {
        logg.info("Eliminando carrito de compra con ID: {}", id);
        return this.carritocompraService.carritocompraDelete(id);
    }
}
