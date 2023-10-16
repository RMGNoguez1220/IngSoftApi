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
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;
    private String descripcion_producto;
    private float precio;
    private String categoria;
    private int stock;
}
