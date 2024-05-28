package model;

import java.util.Date;

public class Voto {

    private Date fechaEmisionVoto;
    private Candidato candidato;
    private Votante votante;

    public Voto(Date fechaEmisionVoto, Candidato candidato, Votante votante) {
        this.fechaEmisionVoto = fechaEmisionVoto;
        this.candidato = candidato;
        this.votante = votante;
    }

    public Date getFechaEmisionVoto() {
        return fechaEmisionVoto;
    }

    public void setFechaEmisionVoto(Date fechaEmisionVoto) {
        this.fechaEmisionVoto = fechaEmisionVoto;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Votante getVotante() {
        return votante;
    }

    public void setVotante(Votante votante) {
        this.votante = votante;
    }
}
