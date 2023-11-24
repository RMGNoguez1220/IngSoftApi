package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Notificacion;
import com.example.ingsoftapi.services.NotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/Notificacion")
public class NotificacionController {

    private static final Logger logg = LoggerFactory.getLogger(CarritoCompraController.class);
    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllNotificacion() {
        logg.info("Solicitando la lista de todas las notificaciones");
        return notificacionService.getNotificacion();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertNotificacion(@RequestBody Notificacion notifiacion) {
        logg.info("Registrando una nueva notificación: {}", notifiacion);
        return this.notificacionService.notificacionInsert(notifiacion);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateNotificacion(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        logg.info("Actualizando información de la notificación con ID: {} - {}", id, notificacion);
        return this.notificacionService.notificacionUpdate(id, notificacion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteNotificacion(@PathVariable Long id) {
        logg.info("Eliminando la notificación con ID: {}", id);
        return this.notificacionService.notificacionDelete(id);
    }

}
