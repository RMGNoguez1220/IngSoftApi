package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.model.Usuario;
import com.example.ingsoftapi.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    private final ProductoService productoService;

    @Autowired
    public UsuarioController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsuario() {
        return productoService.getProductos();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> insertUsuario(@RequestBody Usuario usuario) {
        return this.productoService.insertProducto(usuario);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return this.productoService.updateProducto(id, usuario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable Long id) {
        return this.productoService.productDelete(id);
    }

}
