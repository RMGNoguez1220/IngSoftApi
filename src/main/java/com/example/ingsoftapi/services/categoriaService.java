package com.example.ingsoftapi.services;

import com.example.ingsoftapi.models.categoria;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class categoriaService {

    public List<categoria> getCategorias() {
        return List.of(
                new categoria(
                        1,
                        "electronicos"
                ));

    }
}
