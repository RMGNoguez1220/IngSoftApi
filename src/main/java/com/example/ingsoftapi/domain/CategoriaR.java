package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.categoria;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoriaR extends R {
    private Categoria categoria;
    private List<Categoria> listCategoria;
    HashMap<String,Object> data = new HashMap<>();
    public CategoriaR(Categoria categoria, String message, int status, boolean flag){
        super(flag, message, status);
        this.categoria=categoria;

    }
    public CategoriaR(String message,int status,boolean flag){
        super(flag, message, status);

    }
    public CategoriaR(List<Categoria> listCategoria,String message, int status, boolean flag){
        super(flag, message, status);
        this.listCategoria=listCategoria;

    }
    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.categoria);
        return data;
    }
}

