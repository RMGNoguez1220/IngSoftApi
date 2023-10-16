package com.example.ingsoftapi.model;

import jakarta.persistence.*;
import lombok.*; //es empleada para usar todas las que conlleva o puede tener como GET, SETTER, NoArgsConstructor, ETC

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    private String nombre_usuario;
    private String correo_electronico;
    private String contrasena;
    private String rol;
}
