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
    private CarritoProducto carritoproducto;
    private List<CarritoProducto> carritoproductoList;
    private HashMap<String, Object> data = new HashMap<>();

    public CarritoProductoResponse(final List<CarritoProducto> carritoproductoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.carritoproductoList = carritoproductoList;
    }

    public CarritoProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public CarritoProductoResponse(CarritoProducto carritoproducto, String message, int status, boolean flag) {
        super (flag, message, status);
        this.carritoproducto = carritoproducto;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.carritoproductoList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.carritoproducto);
        return data;
    }
}
