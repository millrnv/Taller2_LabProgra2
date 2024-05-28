package model;

import java.util.List;

public class Candidato {

    private String nombre, rut, partidoPolitico;
    private Cargo cargo;
    private List<Eleccion> elecciones;

    public Candidato(String nombre, String rut, String partidoPolitico, Cargo cargo) {
        this.nombre = nombre;
        this.rut = rut;
        this.partidoPolitico = partidoPolitico;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
