package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.ResenaProducto;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ResenaProductoResponse extends SuperResponse{
    private ResenaProducto resenaProducto;
    private List<ResenaProducto> resenaProductoList;
    private HashMap<String, Object> data = new HashMap<>();

    public ResenaProductoResponse(final List<ResenaProducto> resenaProductoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.resenaProductoList = resenaProductoList;
    }

    public ResenaProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public ResenaProductoResponse(ResenaProducto resenaProducto, String message, int status, boolean flag) {
        super (flag, message, status);
        this.resenaProducto = resenaProducto;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.resenaProductoList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.resenaProducto);
        return data;
    }
}
