package model.data.dao;

import model.Votante;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.ArrayList;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;
public class VotanteDAO {

    public static void registrarVotante(DSLContext query, Votante votante) {
        Table tablaVotante = table(name("votante"));
        Field[] columnas = tablaVotante.fields("rut", "nombreCompleto", "numeroTelefono", "direccion", "preferenciaPolitica");
        query.insertInto(tablaVotante, columnas[0], columnas[1], columnas[2], columnas[3])
                .values(votante.getNombre(), votante.getRut(), votante.getnTelefonico(), votante.getPreferenciaPolitica())
                .execute();
    }

    public static boolean validarExistenciaVotante(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("votante")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }

}
