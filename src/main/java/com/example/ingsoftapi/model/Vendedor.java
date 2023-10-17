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
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_vendedor;
    private String nombre_tienda;
    private String descripcion_tienda;
    private String categoria;
}
