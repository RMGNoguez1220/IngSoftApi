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
    private OrdenCompra ordenCompra;
    private List<OrdenCompra> ordenCompraList;
    private HashMap<String, Object> data = new HashMap<>();

    public OrdenCompraResponse(final List<OrdenCompra> ordenCompraList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.ordenCompraList = ordenCompraList;
    }

    public OrdenCompraResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public OrdenCompraResponse(OrdenCompra ordenCompra, String message, int status, boolean flag) {
        super (flag, message, status);
        this.ordenCompra = ordenCompra;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ordenCompraList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ordenCompra);
        return data;
    }
}

