package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Pedido;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PedidoResponse extends Response {
    private Pedido pedido;
    private List<Pedido> listPedido;
    private HashMap<String, Object> data = new HashMap<>();

    public PedidoResponse(final Pedido pedido, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.pedido = pedido;
    }

    public PedidoResponse(final String message, final int status, final boolean flag) {
        super(flag, message, status);
    }

    public PedidoResponse(final List<Pedido> pedidoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.listPedido = pedidoList;
    }

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.pedido);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listPedido);
        return data;
    }
}

