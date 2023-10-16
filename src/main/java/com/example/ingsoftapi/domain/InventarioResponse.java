package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Inventario;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class InventarioResponse extends SuperResponse{
    private Inventario inventario;
    private List<Inventario> inventarioList;
    private HashMap<String, Object> data = new HashMap<>();

    public InventarioResponse(final List<Inventario> inventarioList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.inventarioList = inventarioList;
    }

    public InventarioResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public InventarioResponse(Inventario inventario, String message, int status, boolean flag) {
        super (flag, message, status);
        this.inventario = inventario;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.inventarioList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.inventario);
        return data;
    }
}

