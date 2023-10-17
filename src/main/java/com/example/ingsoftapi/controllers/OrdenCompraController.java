package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Orden_compra")
public class OrdenCompraController {
    private final Orden_compraService ordenCompraService;

    public notificacionController(Orden_compraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllNotificacion() {
        return ordenCompraService.getOrdencompra();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> NotificacionVendedor(@RequestBody Ordencompra ordencompra) {
        return this.ordenCompraService.insertOrdencompra(ordencompra);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateNotificacion(@PathVariable Long id, @RequestBody Ordencompra ordencompra) {
        return this.ordenCompraService.updateOrdencompra(id, ordencompra);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> NotificacionDelete(@PathVariable Long id) {
        return this.NotificacionService.NotificacionDelete(id);
    }
}
