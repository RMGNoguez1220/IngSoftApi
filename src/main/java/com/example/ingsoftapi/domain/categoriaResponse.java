package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.models.categoria;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class categoriaResponse extends genericResponse{
    private categoria Categoria;
    private List<categoria> listCategoria;
    HashMap<String,Object> datos = new HashMap<>();

    public categoriaResponse(categoria Categoria, String message, int status, boolean flag){
        super(flag, message, status);
        this.Categoria=Categoria;

    }

    //DELETE
    public categoriaResponse(String message,int status,boolean flag){
        super(flag, message, status);

    }

    //GET All
    public categoriaResponse(List<categoria> listCategoria,String message, int status, boolean flag){
        super(flag, message, status);
        this.listCategoria=listCategoria;
    }

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.Categoria);
        return datos;
    }

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listCategoria);
        return datos;
    }
}
