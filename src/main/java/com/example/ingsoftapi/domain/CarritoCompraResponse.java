package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.CarritoCompra;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CarritoCompraResponse extends SuperResponse{
    private CarritoCompra carritoCompra;
    private List<CarritoCompra> carritoCompraList;
    private HashMap<String, Object> data = new HashMap<>();

    public CarritoCompraResponse(final List<CarritoCompra> carritoCompraList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.carritoCompraList = carritoCompraList;
    }

    public CarritoCompraResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public CarritoCompraResponse(CarritoCompra carritoCompra, String message, int status, boolean flag) {
        super (flag, message, status);
        this.carritoCompra = carritoCompra;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.carritoCompraList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.carritoCompra);
        return data;
    }
}

