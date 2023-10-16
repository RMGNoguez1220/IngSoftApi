package com.example.ingsoftapi.model;

//Librerias a emplear
import jakarta.persistence.*;
import lombok.*; //es empleada para usar todas las que conlleva o puede tener como GET, SETTER, NoArgsConstructor, ETC



 //Genera constructores que no toman argumentos, un argumento por campo final/no nulo, o un argumento por cada campo.
 @NoArgsConstructor //generará un constructor sin parámetros.
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table

public class Comprador {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id_comprador; //campo que se tiene
     private int id_usuario; //llave foranea

 }
