package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Producto;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoResponse extends Response {
    private Producto producto;
    private List<Producto> listProducto;
    HashMap<String,Object> data = new HashMap<>();

    public ProductoResponse(Producto producto, String message, int status, boolean flag){
        super(flag, message, status);
        this.producto = producto;
    }

    public ProductoResponse(String message, int status, boolean flag){
        super(flag,message,status);
    }

    public ProductoResponse(List<Producto> listProducto, String message, int status, boolean flag){
        super(flag,message,status);
        this.listProducto = listProducto;
    }

    public Object response(){
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data",this.producto);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listProducto);
        return data;
    }
}

