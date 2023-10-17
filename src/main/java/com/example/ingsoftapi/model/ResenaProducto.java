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
public class ResenaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_resena;//llama primaria
    private long id_usuario; //llave foranea
    private long id_producto; //llave foranea
    private int calificacion;
    private String comentario;

}
