package com.example.ingsoftapi.models;

public class categoria {

    private long categoria_id;
    private String categoria;

    public categoria() {
    }

    public categoria(long categoria_id, String categoria) {
        this.categoria_id = categoria_id;
        this.categoria = categoria;
    }

    public categoria(String categoria) {
        this.categoria = categoria;
    }

    public long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(long categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
