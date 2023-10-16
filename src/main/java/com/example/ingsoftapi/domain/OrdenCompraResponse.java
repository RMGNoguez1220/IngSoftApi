package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.OrdenCompra;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrdenCompraResponse extends SuperResponse{
    private OrdenCompra ordencompra;
    private List<OrdenCompra> ordencompraList;
    private HashMap<String, Object> data = new HashMap<>();

    public OrdenCompraResponse(final List<OrdenCompra> ordencompraList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.ordencompraList = ordencompraList;
    }

    public OrdenCompraResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public OrdenCompraResponse(OrdenCompra ordencompra, String message, int status, boolean flag) {
        super (flag, message, status);
        this.ordencompra = ordencompra;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ordencompraList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ordencompra);
        return data;
    }
}

