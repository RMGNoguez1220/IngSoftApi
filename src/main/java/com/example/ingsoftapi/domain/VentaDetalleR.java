package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.VentaDetalle;
import lombok.*;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VentaDetalleR extends Response {
    private VentaDetalle ventaDetalle;
    private List<VentaDetalle> listVentaD;
    private HashMap<String, Object> data = new HashMap<>();

    public VentaDetalleR(final VentaDetalle ventaDetalle, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.ventaDetalle = ventaDetalle;
    }

    public VentaDetalleR(final String message, final int status, final boolean flag) {
        super(flag, message, status);
    }

    public VentaDetalleR(final List<VentaDetalle> ventaDetalleList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.listVentaD = ventaDetalleList;
    }

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.ventaDetalle);
        return data;
    }

    public Object response2() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listVentaD);
        return data;
    }
}

