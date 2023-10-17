package com.example.ingsoftapi.repository;

import com.example.ingsoftapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}