package com.example.ingsoftapi.services;

import com.example.ingsoftapi.domain.CompradorResponse;
import com.example.ingsoftapi.domain.UsuarioResponse;
import com.example.ingsoftapi.model.Comprador;
import com.example.ingsoftapi.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorService {
    private final CompradorRepository compradorRepository;
    private CompradorResponse compradorResponse;

    @Autowired
    public CompradorService(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    public ResponseEntity<Object> getComprador() {
        List<Comprador> compradorList = compradorRepository.findAll();
        if (!compradorList.isEmpty()) {
            compradorResponse = new CompradorResponse(compradorList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(compradorResponse.responseAll(), HttpStatus.OK);
        } else {
            compradorResponse = new CompradorResponse("No hay registros", 400, false);
            return new ResponseEntity<>(compradorResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> compradorInsert(Comprador comprador) {
        this.compradorRepository.save(comprador);
        compradorResponse = new CompradorResponse(comprador, "Se pudo crear el nuevo comprador", 200, true);
        return new ResponseEntity<>(compradorResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> compradorUpdate(final Long id, final Comprador comprador) {
        if (compradorRepository.findById(id).isPresent()) {
            Comprador compradorUpdated = compradorRepository.findById(id).get();
            compradorUpdated.setId_comprador(comprador.getId_comprador());
            compradorUpdated.setId_usuario(comprador.getId_usuario());
            compradorRepository.save(compradorUpdated);
            compradorResponse = new CompradorResponse(compradorUpdated, "El comprador se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(compradorResponse.responseInsert(), HttpStatus.OK);
        } else {
            compradorResponse = new CompradorResponse("El comprador no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(compradorResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> compradorDelete(final Long id) {
        if (!this.compradorRepository.findById(id).isEmpty()) {
            this.compradorRepository.deleteById(id);
            compradorResponse = new CompradorResponse("Se ha eliminado el comprador", 200, true);
            return new ResponseEntity<>(compradorResponse.responseInsert(), HttpStatus.OK);
        } else {
            compradorResponse = new CompradorResponse("No se encontró el comprador que quieres borrar ", 400, false);
            return new ResponseEntity<>(compradorResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
