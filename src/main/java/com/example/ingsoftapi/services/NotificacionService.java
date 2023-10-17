package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.NotificacionResponse;
import com.example.ingsoftapi.model.Notificacion;
import com.example.ingsoftapi.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private NotificacionResponse notificacionResponse;

    @Autowired
    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public ResponseEntity<Object> getNotificacion() {
        List<Notificacion> notificacionList = notificacionRepository.findAll();
        if (!notificacionList.isEmpty()) {
            notificacionResponse = new NotificacionResponse(notificacionList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(notificacionResponse.responseAll(), HttpStatus.OK);
        } else {
            notificacionResponse = new NotificacionResponse("No hay registros", 400, false);
            return new ResponseEntity<>(notificacionResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> notificacionInsert(Notificacion notificacion) {
        this.notificacionRepository.save(notificacion);
        notificacionResponse = new NotificacionResponse(notificacion, "Se pudo crear la notificación", 200, true);
        return new ResponseEntity<>(notificacionResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> notificacionUpdate(final Long id, final Notificacion notificacion) {
        if (notificacionRepository.findById(id).isPresent()) {
            Notificacion notificacionUpdated = notificacionRepository.findById(id).get();
            notificacionUpdated.setId_usuario(notificacion.getId_usuario());
            notificacionUpdated.setTipo_notificacion(notificacion.getTipo_notificacion());
            notificacionUpdated.setContenido(notificacion.getContenido());
            notificacionUpdated.setFecha_hora(notificacion.getFecha_hora());
            notificacionRepository.save(notificacionUpdated);
            notificacionResponse = new NotificacionResponse(notificacionUpdated, "La notificación se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(notificacionResponse.responseInsert(), HttpStatus.OK);
        } else {
            notificacionResponse = new NotificacionResponse("La notificacion no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(notificacionResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> notificacionDelete(final Long id) {
        if (!this.notificacionRepository.findById(id).isEmpty()) {
            this.notificacionRepository.deleteById(id);
            notificacionResponse = new NotificacionResponse("Se ha eliminado la notificación", 200, true);
            return new ResponseEntity<>(notificacionResponse.responseInsert(), HttpStatus.OK);
        } else {
            notificacionResponse = new NotificacionResponse("No se encontró la notificación que quieres borrar ", 400, false);
            return new ResponseEntity<>(notificacionResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
