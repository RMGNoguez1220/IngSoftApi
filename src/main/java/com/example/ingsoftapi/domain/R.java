package com.example.ingsoftapi.domain;

import lombok.*;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class R{
    private boolean flag;
    private String message;
    private int statusCode;

}