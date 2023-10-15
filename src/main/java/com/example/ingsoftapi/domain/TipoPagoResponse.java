package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.models.TipoPago;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TipoPagoResponse extends genericResponse{
    private TipoPago tipoPago;
    private List<TipoPago> listTipoPago;
    HashMap<String,Object> datos = new HashMap<>();
    //GET ONE POST PATCH
    public TipoPagoResponse(TipoPago tipoPago, String message, int status, boolean flag){
        super(flag, message, status);
        this.tipoPago=tipoPago;

    }
    //DELETE
    public TipoPagoResponse(String message, int status, boolean flag){
        super(flag, message, status);

    }

    //GET All
    public TipoPagoResponse(List<TipoPago> listTipoPago, String message, int status, boolean flag){
        super(flag, message, status);
        this.listTipoPago=listTipoPago;

    }
    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.tipoPago);
        return datos;
    }

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listTipoPago);
        return datos;
    }
}
