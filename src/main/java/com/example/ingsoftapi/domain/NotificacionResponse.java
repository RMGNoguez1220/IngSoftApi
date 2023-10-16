package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Notificacion;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class NotificacionResponse extends SuperResponse{
    private Notificacion notificacion;
    private List<Notificacion> notificacionList;
    private HashMap<String, Object> data = new HashMap<>();

    public NotificacionResponse(final List<Notificacion> notificacionList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.notificacionList = notificacionList;
    }

    public NotificacionResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public NotificacionResponse(Notificacion notificacion, String message, int status, boolean flag) {
        super (flag, message, status);
        this.notificacion = notificacion;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.notificacionList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.notificacion);
        return data;
    }
}

