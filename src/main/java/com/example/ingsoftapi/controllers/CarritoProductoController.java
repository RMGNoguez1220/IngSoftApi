package com.example.ingsoftapi.controllers;

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
    public ResponseEntity<Object> getAllCarrito_producto() {
        return carritoproductoService.getCarrito_producto();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertCarrito_producto(@RequestBody Carrito_producto carritoProducto) {
        return this.carritoproductoService.insertCarrito_producto(carritoProducto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCarrito_producto(@PathVariable Long id, @RequestBody Carrito_producto carritoProducto) {
        return this.carritoproductoService.updateCarrito_producto(id, carritoProducto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> Carrito_productoDelete(@PathVariable Long id) {
        return this.carritoproductoService.Carrito_productoDelete(id);
    }
}
