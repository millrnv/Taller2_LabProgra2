package model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;
import java.sql.Connection;
import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaEleccion(create);
        crearTablaCandidato(create);
        crearTablaVotante(create);
        crearTablaVoto(create);
        relacionarTabla(create, "Voto", "rut", "Candidato");
        DBConnector.closeConnection();
    }

    // metodo para conectarse a una base de datos ya creada
    public static DSLContext conectarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    // crea una base de datos en caso de que no exista
    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    // actualiza la conexion inicial para conectar a la base de datos
    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearTablaEleccion(DSLContext create) {
        create.createTableIfNotExists("Eleccion")
                .column("nombre", VARCHAR(100))
                .column("fecha", VARCHAR(50))
                .column("lugar", VARCHAR(100))
                .column("candidatos", VARCHAR(100))
                .constraint(primaryKey("nombre"))
                .execute();
    }


    private static void crearTablaCandidato(DSLContext create) {
        create.createTableIfNotExists("Candidato")
                .column("nombre", VARCHAR(100))
                .column("rut", VARCHAR(15))
                .column("partidoPolitico", VARCHAR(50))
                .column("cargo", VARCHAR(50))
                .constraint(primaryKey("rut"))
                .execute();
    }


    private static void crearTablaVotante(DSLContext create) {
        create.createTableIfNotExists("Votante")
                .column("nombre", VARCHAR(100))
                .column("rut", VARCHAR(12))
                .column("nTelefonico", VARCHAR(12))
                .column("preferenciaPolitica", VARCHAR(50))
                .constraint(primaryKey("rut"))
                .execute();
    }


    private static void crearTablaVoto(DSLContext create) {
        create.createTableIfNotExists("Voto")
                .column("candidatoElegido", VARCHAR(100))
                .column("fecha", VARCHAR(25))
                .constraint(primaryKey("fecha"))
                .execute();
    }

    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }

    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna) {
        create.alterTableIfExists(nombreTabla).addColumn(columna, tipoColumna);
    }
}
