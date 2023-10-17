package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Usuario;
import com.example.ingsoftapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsuario() {
    return usuarioService.getUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.insertUser(usuario);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return this.usuarioService.updateUser(id, usuario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable Long id) {
        return this.usuarioService.deleteUser(id);
    }

}
