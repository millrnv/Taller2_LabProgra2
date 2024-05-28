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
        relacionarTabla(create, "Elección", "id", "Cargo");
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

    // metodo estandar para crear una tabla
    private static void crearTablaEleccion(DSLContext create) {
        create.createTableIfNotExists("Eleccion")
                .column("nombre", VARCHAR(100))
                .column("lugar", VARCHAR(100))
                .column("id", VARCHAR(50))
                .column("fecha", DATE)
                .constraint(primaryKey("id"))
                .execute();
    }

    // relaciona dos tablas a traves de una clave foranea, usar solo si se relacionan tablas
    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }

    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna) {
        create.alterTableIfExists(nombreTabla).addColumn(columna, tipoColumna);
    }
}
