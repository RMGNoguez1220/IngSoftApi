package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Notificacion;
import com.example.ingsoftapi.services.NotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Notificacion")
public class NotificacionController {
    private final NotificacionService notificacionService;

    public NotificacionController(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllNotificacion() {
        return notificacionService.getNotificacion();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertNotificacion(@RequestBody Notificacion notifiacion) {
        return this.notificacionService.notificacionInsert(notifiacion);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateNotificacion(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        return this.notificacionService.notificacionUpdate(id, notificacion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteNotificacion(@PathVariable Long id) {
        return this.notificacionService.notificacionDelete(id);
    }

}
