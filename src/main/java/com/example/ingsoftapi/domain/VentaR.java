package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Venta;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VentaR extends Response{
    private Venta venta;
    private List<Venta> listVenta;
    HashMap<String,Object> data = new HashMap<>();

    public VentaR(Venta venta,String message,int status,boolean flag){
        super(flag, message, status);
        this.venta=venta;

    }

    public VentaR(String message,int status,boolean flag){
        super(flag, message, status);

    }

    public VentaR(List<Venta> listVenta,String message, int status, boolean flag){
        super(flag, message, status);
        this.listVenta=listVenta;

    }
    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.venta);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listVenta);
        return data;
    }
}

