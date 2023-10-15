package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Tienda;
import lombok.*;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TiendaR extends Response {
    private Tienda tienda;
    private List<Tienda> listTienda;
    HashMap<String, Object> data = new HashMap<>();

    public TiendaR(Tienda tienda, String message, int status, boolean flag) {
        super(flag, message, status);
        this.tienda = tienda;
    }

    public TiendaR(String message, int status, boolean flag) {
        super(flag, message, status);

    }

    public TiendaR(List<Tienda> listTienda, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listTienda = listTienda;
    }

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.tienda);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listTienda);
        return data;
    }
}
