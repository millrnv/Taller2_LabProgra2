package model;

import java.util.List;

public class Votante {

    private String nombre, rut, nTelefonico, preferenciaPolitica;
    private List<Votante> votantes;

    public Votante(String nombre, String rut, String nTelefonico, String preferenciaPolitica) {
        this.nombre = nombre;
        this.rut = rut;
        this.nTelefonico = nTelefonico;
        this.preferenciaPolitica = preferenciaPolitica;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getnTelefonico() {
        return nTelefonico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setnTelefonico(String getnTelefonico) {
        this.nTelefonico = getnTelefonico;
    }

    public String getPreferenciaPolitica() {
        return preferenciaPolitica;
    }

    public void setPreferenciaPolitica(String preferenciaPolitica) {
        this.preferenciaPolitica = preferenciaPolitica;
    }
    @Override
    public String toString() {
        return "Votante{" + "nombre=" + nombre + ", rut=" + rut + ", getnTelefonico=" + nTelefonico + '}';
    }



}
