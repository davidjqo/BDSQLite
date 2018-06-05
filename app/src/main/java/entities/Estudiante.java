package entities;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String id, nombre, apellido;
    private int edad;

    public void Estudiante() {
        this.id = "";
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String toString() {
        return "ID: " + id + "Nombre: " + nombre + "Apellido: " + apellido + "Edad: " + edad;
    }
}
