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
public class ProductoResponse extends SuperResponse{
    private Producto producto;
    private List<Producto> productoList;
    private HashMap<String, Object> data = new HashMap<>();

    public ProductoResponse(final List<Producto> productoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.productoList = productoList;
    }

    public ProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public ProductoResponse(Producto producto, String message, int status, boolean flag) {
        super (flag, message, status);
        this.producto = producto;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.productoList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.producto);
        return data;
    }
}
