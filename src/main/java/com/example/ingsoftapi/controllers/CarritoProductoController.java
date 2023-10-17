package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.CarritoProducto;
import com.example.ingsoftapi.services.CarritoProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carrito_producto")
public class CarritoProductoController {

    private final CarritoProductoService carritoproductoService;

    public CarritoProductoController(CarritoProductoService carritoproductoService) {
        this.carritoproductoService = carritoproductoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCarritoProducto() {
        return carritoproductoService.getCarritoProducto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertCarritoProducto(@RequestBody CarritoProducto carritoProducto) {
        return this.carritoproductoService.carritoproductoInsert(carritoProducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCarritoProducto(@PathVariable Long id, @RequestBody CarritoProducto carritoProducto) {
        return this.carritoproductoService.carritoproductoUpdate(id, carritoProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCarritoProducto(@PathVariable Long id) {
        return this.carritoproductoService.carritoproductoDelete(id);
    }
}
