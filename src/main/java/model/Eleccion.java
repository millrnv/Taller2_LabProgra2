package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Eleccion {

    //atributo nombre de la eleccion, fecha, lugar donde se llevará a cabo y los candidatos que participaran
    private String nombre, lugar;
    private Date fecha;
    private List<Candidato> candidatos;
    private List<Votante> votantes;

    //constructor de la clase
    public Eleccion(String nombre, Date fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.candidatos = new ArrayList<Candidato>();
    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public List<Votante> getVotantes() {
        return votantes;
    }

    public void setVotantes(List<Votante> votantes) {
        this.votantes = votantes;
    }
}
