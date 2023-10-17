package com.example.ingsoftapi.repository;

import com.example.ingsoftapi.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
