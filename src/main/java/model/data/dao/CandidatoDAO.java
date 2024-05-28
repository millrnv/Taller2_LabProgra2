package model.data.dao;

import model.Candidato;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.ArrayList;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;
public class CandidatoDAO {

    public static void registrarCandidato(DSLContext query, Candidato candidato) {
        Table tablaCandidato = table(name("candidato"));
        Field[] columnas = tablaCandidato.fields("rut", "nombreCompleto", "partidoPolitico", "cargoQueAspira");
        query.insertInto(tablaCandidato, columnas[0], columnas[1], columnas[2], columnas[3])
                .values(candidato.getRut(), candidato.getNombre(), candidato.getPartidoPolitico(),
                        candidato.getCargo())
                .execute();
    }

    public static boolean validarExistenciaCandidato(DSLContext query, String columnaTabla, Object dato) {
        Result resultados = query.select().from(DSL.table("candidato")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if (resultados.size() >= 1) {
            return true;
        } else {
            return false;
        }
    }



}
