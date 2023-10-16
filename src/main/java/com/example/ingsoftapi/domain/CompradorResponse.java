package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Comprador;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CompradorResponse extends SuperResponse{
    private Comprador comprador;
    private List<Comprador> compradorList;
    private HashMap<String, Object> data = new HashMap<>();

    public CompradorResponse(final List<Comprador> compradorList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.compradorList = compradorList;
    }

    public CompradorResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public CompradorResponse(Comprador comprador, String message, int status, boolean flag) {
        super (flag, message, status);
        this.comprador = comprador;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.compradorList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.comprador);
        return data;
    }
}
