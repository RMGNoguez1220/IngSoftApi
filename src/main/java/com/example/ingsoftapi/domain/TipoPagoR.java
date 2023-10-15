package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.TipoPago;
import lombok.*;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TipoPagoR extends Response{
    private TipoPago tipoPago;
    private List<TipoPago> listTipoPago;
    HashMap<String,Object> data = new HashMap<>();

    public TipoPagoR(TipoPago tipoPago, String message, int status, boolean flag){
        super(flag, message, status);
        this.tipoPago=tipoPago;

    }

    public TipoPagoR(String message,int status,boolean flag){
        super(flag, message, status);

    }

    public TipoPagoR(List<TipoPago> listTipoPago,String message, int status, boolean flag){
        super(flag, message, status);
        this.listTipoPago=listTipoPago;

    }
    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.tipoPago);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listTipoPago);
        return data;
    }
}

