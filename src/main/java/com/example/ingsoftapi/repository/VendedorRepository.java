package com.example.ingsoftapi.repository;

import com.example.ingsoftapi.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}