package com.example.ingsoftapi.repository;

import com.example.ingsoftapi.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompradorRepository extends JpaRepository<Comprador, Long> {
}