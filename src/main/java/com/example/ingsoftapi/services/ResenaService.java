package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.ResenaResponse;
import com.example.ingsoftapi.domain.TiendaResponse;
import com.example.ingsoftapi.model.Resena;
import com.example.ingsoftapi.model.Tienda;
import com.example.ingsoftapi.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResenaService {
    private final ResenaRepository resenaRepository;
    ResenaResponse response;
    @Autowired
    public ResenaService(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    public ResponseEntity<Object> getResena() {
        List<Resena> resenas = resenaRepository.findAll();
        if (!resenas.isEmpty()) {
            response = new ResenaResponse(resenas, "Reseñas", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new ResenaResponse("No hay reseñas", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> newResena(Resena resena) {
        this.resenaRepository.save(resena);
        response = new ResenaResponse(resena, "Reseña creada exitosamente", 200, true);
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateResena(Integer id, Resena resena) {
        if (resenaRepository.findById(Long.valueOf(id)).isPresent()) {
            Resena existingResena = resenaRepository.findById(Long.valueOf(id)).get();
            existingResena.setResena(resena.getResena());
            existingResena.setCalificacion(resena.getCalificacion());
            existingResena.setProducto_id(resena.getProducto_id());
            existingResena.setUsuario_id(resena.getUsuario_id());
            resenaRepository.save(existingResena);
            response = new ResenaResponse(existingResena, "Actualizacion exitosa", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ResenaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> eliminarResena(Integer id) {
        //Verificar si esta vacio
        if (!this.resenaRepository.findById(Long.valueOf(id)).isEmpty()) {
            this.resenaRepository.deleteById(Long.valueOf(id));
            response = new ResenaResponse("Eliminacion exitosa:", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ResenaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        if (resenaRepository.findById(Long.valueOf(id)).isPresent()) {
            Resena resena = resenaRepository.findById(Long.valueOf(id)).get();
            response = new ResenaResponse(resena, "ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ResenaResponse("No existe la tienda con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
