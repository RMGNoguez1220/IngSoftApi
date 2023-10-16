package com.example.ingsoftapi.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SuperResponse {
    private boolean flag;
    private String message;
    private int statusCode;
}
