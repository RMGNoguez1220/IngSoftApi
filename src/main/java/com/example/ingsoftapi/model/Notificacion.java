package com.example.ingsoftapi.model;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_notificacion;
    private long id_usuario;
    private String tipo_notificacion;
    private String contenido;
    private String fecha_hora;

}
