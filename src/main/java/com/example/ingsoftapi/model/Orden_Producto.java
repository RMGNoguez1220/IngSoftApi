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
public class Orden_Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_orden;
    private long id_producto;
    private int cantidad;
}
