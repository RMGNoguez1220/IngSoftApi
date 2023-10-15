package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.estadopedido;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EstadoPedidoR extends Response {
    private EstadoPedido estadoPedido;
    private List<EstadoPedido> listEstadoPedido;
    private HashMap<String, Object> data = new HashMap<>();

    public EstadoPedidoR(final EstadoPedido estadoPedido, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.estadoPedido = estadoPedido;
    }

    public EstadoPedidoR(final String message, final int status, final boolean flag) {
        super(flag, message, status);
    }

    public EstadoPedidoR(final List<EstadoPedido> estadoPedidoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.listEstadoPedido = estadoPedidoList;
    }

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.estadoPedido);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listEstadoPedido);
        return data;
    }
}

