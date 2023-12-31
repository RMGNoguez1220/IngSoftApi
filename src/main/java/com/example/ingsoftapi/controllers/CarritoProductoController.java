package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.CarritoProducto;
import com.example.ingsoftapi.services.CarritoProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/carrito_producto")
public class CarritoProductoController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);

    private final CarritoProductoService carritoproductoService;

    public CarritoProductoController(CarritoProductoService carritoproductoService) {
        this.carritoproductoService = carritoproductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCarritoProducto() {
        logg.info("Solicitando todos los productos del carrito");
        return carritoproductoService.getCarritoProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertCarritoProducto(@RequestBody CarritoProducto carritoProducto) {
            logg.info("Agregando nuevo producto al carrito: {}", carritoProducto);
        return this.carritoproductoService.carritoproductoInsert(carritoProducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCarritoProducto(@PathVariable Long id, @RequestBody CarritoProducto carritoProducto) {
        logg.info("Actualizando producto en el carrito con ID: {} - {}", id, carritoProducto);
        return this.carritoproductoService.carritoproductoUpdate(id, carritoProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCarritoProducto(@PathVariable Long id) {
        logg.info("Eliminando producto del carrito con ID: {}", id);
        return this.carritoproductoService.carritoproductoDelete(id);
    }
}
