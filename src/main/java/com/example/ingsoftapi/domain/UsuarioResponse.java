package com.example.ingsoftapi.domain;

import com.example.ingsoftapi.model.Usuario;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UsuarioResponse extends SuperResponse {

    private Usuario usuario;
    private List<Usuario> usuarioList;
    private HashMap<String, Object> data = new HashMap<>();

    public UsuarioResponse(final List<Usuario> usuarioList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.usuarioList = usuarioList;
    }

    public UsuarioResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public UsuarioResponse(Usuario usuario, String message, int status, boolean flag) {
        super (flag, message, status);
        this.usuario = usuario;
    }

    public Object responseAll() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.usuarioList);
        return data;
    }

    public Object responseInsert() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.usuario);
        return data;
    }
}
