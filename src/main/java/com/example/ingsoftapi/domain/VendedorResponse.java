package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Vendedor;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class VendedorResponse extends SuperResponse{
    private Vendedor vendedor;
    private List<Vendedor> vendedorList;
    private HashMap<String, Object> data = new HashMap<>();

    public VendedorResponse(final List<Vendedor> vendedorList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.vendedorList = vendedorList;
    }

    public VendedorResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public VendedorResponse(Vendedor vendedor, String message, int status, boolean flag) {
        super (flag, message, status);
        this.vendedor = vendedor;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.vendedorList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.vendedor);
        return data;
    }
}
