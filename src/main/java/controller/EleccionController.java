package controller;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import model.Candidato;
import model.Cargo;
import model.Eleccion;
import model.Votante;
import model.data.DBConnector;
import model.data.DBGenerator;

import model.data.dao.CandidatoDAO;
import model.data.dao.EleccionDAO;
import model.data.dao.VotanteDAO;
import org.jooq.DSLContext;

import java.util.Date;

public class EleccionController {

    private static final String nombreBD = "Elecciones transparentes";

    //método para registrar elección con nombre, lugar y fecha
    public boolean registrarEleccion(String nombre, Date fecha, String lugar) throws ClassNotFoundException{
        DSLContext query = DBGenerator.conectarBD(nombreBD);
        if (!EleccionDAO.validarExistenciaEleccion(query, "nombreEleccion", nombre)) {
            Eleccion eleccion = new Eleccion(nombre, fecha, lugar);
            EleccionDAO.registrarEleccion(query, eleccion);
            DBConnector.closeConnection();
            return true;
        } else {
            DBConnector.closeConnection();
            return false;
        }
    }

    // metodo registro votantes rut, nombreCompleto, numeroTelefono, direccion, preferenciaPolitica
    public static boolean registrarVotante(String nombre, String rut, String nTelefonico, String preferenciaPolitica) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreBD);
        if (!VotanteDAO.validarExistenciaVotante(query, "rut", nombre)) {
            Votante votante = new Votante(nombre, rut, nTelefonico, preferenciaPolitica);
            VotanteDAO.registrarVotante(query, votante);
            DBConnector.closeConnection();
            return true;
        } else {
            DBConnector.closeConnection();
            return false;
        }
    }

    public static boolean registrarCandidato(String nombre, String rut, String partidoPolitico, Cargo cargo) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD(nombreBD);
        if (!CandidatoDAO.validarExistenciaCandidato(query, "rut", nombre)) {
            Candidato candidato = new Candidato(nombre, rut, partidoPolitico, cargo);
            CandidatoDAO.registrarCandidato(query, candidato);
            DBConnector.closeConnection();
            return true;
        } else {
            DBConnector.closeConnection();
            return false;
        }
    }



}
