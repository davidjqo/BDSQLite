package entities;

public class Curso {
    private String descripcion;
    private int id, creditos;

    public void Estudiante() {
        this.id = 0;
        this.descripcion = "";
        this.creditos = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getId() {
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
