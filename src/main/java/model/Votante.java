package model;

import java.util.List;

public class Votante {

    private String nombre, rut, getnTelefonico;
    private List<Votante> votantes;

    public Votante(String nombre, String rut, String getnTelefonico) {
        this.nombre = nombre;
        this.rut = rut;
        this.getnTelefonico = getnTelefonico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getnTelefonico() {
        return getnTelefonico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setnTelefonico(String getnTelefonico) {
        this.getnTelefonico = getnTelefonico;
    }

    @Override
    public String toString() {
        return "Votante{" + "nombre=" + nombre + ", rut=" + rut + ", getnTelefonico=" + getnTelefonico + '}';
    }



}
