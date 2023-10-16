package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.OrdenProducto;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrdenProductoResponse extends SuperResponse{
    private OrdenProducto ordenProducto;
    private List<OrdenProducto> ordenProductoList;
    private HashMap<String, Object> data = new HashMap<>();

    public OrdenProductoResponse(final List<OrdenProducto> ordenProductoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.ordenProductoList = ordenProductoList;
    }

    public OrdenProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public OrdenProductoResponse(OrdenProducto ordenProducto, String message, int status, boolean flag) {
        super (flag, message, status);
        this.ordenProducto = ordenProducto;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ordenProductoList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ordenProducto);
        return data;
    }
}

