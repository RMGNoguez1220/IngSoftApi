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
public class PedidoR extends R {
    private Pedido pedido;
    private List<Pedido> listPedido;
    private HashMap<String, Object> data = new HashMap<>();

    public PedidoR(final Pedido pedido, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.pedido = pedido;
    }

    public PedidoR(final String message, final int status, final boolean flag) {
        super(flag, message, status);
    }

    public PedidoR(final List<Pedido> pedidoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.listPedido = pedidoList;
    }

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.pedido);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.listPedido);
        return data;
    }
}

