package com.example.ingsoftapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Notificacion")
public class notificacionController {
    private final NotificacionService notificacionService;

    public notificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllNotificacion() {
        return notificacionService.getNotificacion();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertNotificacion(@RequestBody Notificacion notifiacion) {
        return this.notificacionService.insertNotificacion(notifiacion);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateNotificacion(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        return this.notificacionService.updateNotificacion(id, notificacion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> NotificacionDelete(@PathVariable Long id) {
        return this.NotificacionService.NotificacionDelete(id);
    }

}
