package com.example.ingsoftapi.repository;

import com.example.ingsoftapi.models.categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriaRepository extends JpaRepository<categoria,Long>{
}
