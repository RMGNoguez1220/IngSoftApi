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
    private ResenaProducto resenaproducto;
    private List<ResenaProducto> resenaproductoList;
    private HashMap<String, Object> data = new HashMap<>();

    public ResenaProductoResponse(final List<ResenaProducto> resenaproductoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.resenaproductoList = resenaproductoList;
    }

    public ResenaProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public ResenaProductoResponse(ResenaProducto resenaproducto, String message, int status, boolean flag) {
        super (flag, message, status);
        this.resenaproducto = resenaproducto;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.resenaproductoList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.resenaproducto);
        return data;
    }
}
