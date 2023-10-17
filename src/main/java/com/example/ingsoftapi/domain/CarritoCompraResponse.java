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

public class CarritoCompraResponse extends SuperResponse {
    private CarritoCompra carritocompra;
    private List<CarritoCompra> carritocompraList;
    private HashMap<String, Object> data = new HashMap<>();

    public CarritoCompraResponse(final List<CarritoCompra> carritocompraList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.carritocompraList = carritocompraList;
    }

    public CarritoCompraResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public CarritoCompraResponse(CarritoCompra carritocompra, String message, int status, boolean flag) {
        super(flag, message, status);
        this.carritocompra = carritocompra;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.carritocompraList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.carritocompra);
        return data;
    }
}

