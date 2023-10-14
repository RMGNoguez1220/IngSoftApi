package com.example.ingsoftapi.controllers;

import com.example.ingsoftapi.models.categoria;
import com.example.ingsoftapi.services.categoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/categoria")
public class categoriaController {

    private final categoriaService CategoriaService;

    @Autowired
    public categoriaController(categoriaService CategoriaService){
        this.CategoriaService=CategoriaService;
    }

    @GetMapping
    public List<categoria> getCategorias(){
        return this.CategoriaService.getCategorias();
    }


}
