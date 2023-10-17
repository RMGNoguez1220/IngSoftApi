package com.example.ingsoftapi.repository;

import com.example.ingsoftapi.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}