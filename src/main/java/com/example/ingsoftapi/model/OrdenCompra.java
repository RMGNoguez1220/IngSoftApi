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
public class OrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_orden;
    private long id_usuario;
    private String fecha_hora;
    private String estado;
    private String direccion_envio;
    private String metodo_pago;
    private float monto_total;

}
