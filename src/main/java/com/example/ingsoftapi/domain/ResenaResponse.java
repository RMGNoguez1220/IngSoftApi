package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Resena;

import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResenaResponse extends Response {
    private Resena resena;
    private List<Resena> listResena;
    HashMap<String,Object> data = new HashMap<>();

    public ResenaResponse(Resena resena, String message, int status, boolean flag) {
        super(flag, message, status);
        this.resena = resena;
    }

    //DELETE
    public ResenaResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    //GET All
    public ResenaResponse(List<Resena> listResena, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listResena = listResena;
    }

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.resena);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listResena);
        return data;
    }
}
