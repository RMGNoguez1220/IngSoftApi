package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.CarritoProducto;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CarritoProductoResponse extends SuperResponse{
    private CarritoProducto carritoProducto;
    private List<CarritoProducto> carritoProductoList;
    private HashMap<String, Object> data = new HashMap<>();

    public CarritoProductoResponse(final List<CarritoProducto> carritoProductoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.carritoProductoList = carritoProductoList;
    }

    public CarritoProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public CarritoProductoResponse(CarritoProducto carritoProducto, String message, int status, boolean flag) {
        super (flag, message, status);
        this.carritoProducto = carritoProducto;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.carritoProductoList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.carritoProducto);
        return data;
    }
}
