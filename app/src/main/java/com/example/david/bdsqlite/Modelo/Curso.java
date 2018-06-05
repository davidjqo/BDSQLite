package com.example.david.bdsqlite.Modelo;

public class Curso {
    private String id, descripcion;
    private int creditos;

    public void Estudiante() {
        this.id = "";
        this.descripcion = "";
        this.creditos = 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public String toString() {
        return "ID: " + id + "Descripción: " + descripcion + "Créditos: " + creditos;
    }
}
