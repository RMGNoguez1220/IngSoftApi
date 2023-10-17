package com.example.ingsoftapi.services;


import com.example.ingsoftapi.domain.UsuarioResponse;
import com.example.ingsoftapi.model.Usuario;
import com.example.ingsoftapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private UsuarioResponse usuarioResponse;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseEntity<Object> getUsers() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        if (!usuarioList.isEmpty()) {
            usuarioResponse = new UsuarioResponse(usuarioList, "Se han obtenido los registros", 200, true);
            return new ResponseEntity<>(usuarioResponse.responseAll(), HttpStatus.OK);
        } else {
            usuarioResponse = new UsuarioResponse("No hay registros", 400, false);
            return new ResponseEntity<>(usuarioResponse.responseAll(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> insertUser(Usuario usuario) {
        this.usuarioRepository.save(usuario);
        usuarioResponse = new UsuarioResponse(usuario, "Se pudo crear el pedido", 200, true);
        return new ResponseEntity<>(usuarioResponse.responseInsert(), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateUser(final Long id, final Usuario usuario) {
        if (usuarioRepository.findById(id).isPresent()) {
            Usuario userUpdated = usuarioRepository.findById(id).get();
            userUpdated.setNombre_usuario(usuario.getNombre_usuario());
            userUpdated.setCorreo_electronico(usuario.getCorreo_electronico());
            userUpdated.setContrasena(usuario.getContrasena());
            userUpdated.setRol(usuario.getRol());
            usuarioRepository.save(userUpdated);
            usuarioResponse = new UsuarioResponse(userUpdated, "El usuario se modificó satisfactoriamente", 200, true);
            return new ResponseEntity<>(usuarioResponse.responseInsert(), HttpStatus.OK);
        } else {
            usuarioResponse = new UsuarioResponse("El usuario no existe, con el id: " + id, 400, false);
            return new ResponseEntity<>(usuarioResponse.responseInsert(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> deleteUser(final Long id) {
        if (!this.usuarioRepository.findById(id).isEmpty()) {
            this.usuarioRepository.deleteById(id);
            usuarioResponse = new UsuarioResponse("Se ha eliminado el usuario", 200, true);
            return new ResponseEntity<>(usuarioResponse.responseInsert(), HttpStatus.OK);
        } else {
            usuarioResponse = new UsuarioResponse("No se encontró el usuario que quieres borrar ", 400, false);
            return new ResponseEntity<>(usuarioResponse.responseInsert(), HttpStatus.OK);
        }
    }
}
