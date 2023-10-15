package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.models.categoria;
import com.example.ingsoftapi.services.categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/categoria")
public class categoriaController {

    private final categoriaService CategoriaService;

    @Autowired
    public categoriaController(categoriaService CategoriaService){
        this.CategoriaService=CategoriaService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getCategorias(){
        return this.CategoriaService.getCategoria();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> registrarCategoria(@RequestBody categoria Categoria){
        return this.CategoriaService.newCategoria(Categoria);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarCategoria(@PathVariable Long id,@RequestBody categoria Categoria){
        return this.CategoriaService.updateCategoria(id,Categoria);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.CategoriaService.eliminar(id);

    }


}
