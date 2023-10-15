package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.TipoProducto;
import java.util.HashMap;
import java.util.List;

public class TipoProductoR extends Response{
    private TipoProducto tipoProducto;
    private List<TipoProducto> listTipoProducto;
    HashMap<String,Object> data = new HashMap<>();

    public TipoProductoR(TipoProducto tipoProducto, String message, int status, boolean flag){
        super(flag, message, status);
        this.tipoProducto=tipoProducto;

    }

    public TipoProductoR(String message,int status,boolean flag){
        super(flag, message, status);

    }

    public TipoProductoR(List<TipoProducto> listTipoProducto,String message, int status, boolean flag){
        super(flag, message, status);
        this.listTipoProducto=listTipoProducto;

    }
    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.tipoProducto);
        return data;
    }

    public Object responseList() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.listTipoProducto);
        return data;
    }
}