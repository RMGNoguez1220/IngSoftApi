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
    private OrdenProducto ordenproducto;
    private List<OrdenProducto> ordenproductoList;
    private HashMap<String, Object> data = new HashMap<>();

    public OrdenProductoResponse(final List<OrdenProducto> ordenproductoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.ordenproductoList = ordenproductoList;
    }

    public OrdenProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public OrdenProductoResponse(OrdenProducto ordenproducto, String message, int status, boolean flag) {
        super (flag, message, status);
        this.ordenproducto = ordenproducto;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ordenproductoList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ordenproducto);
        return data;
    }
}

