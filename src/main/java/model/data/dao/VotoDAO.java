package model.data.dao;

import model.Candidato;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Table;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class VotoDAO {

    public static void registrarVoto(DSLContext query, Candidato candidato, String fechaVotacion) {
        Table tablaVotacion = table(name("votacion"));
        Field[] columnas = tablaVotacion.fields("candidatoElegido", "fechaVotacion");
        query.insertInto(tablaVotacion, columnas[0], columnas[1])
                .values(candidato.getNombre(), fechaVotacion)
                .execute();
    }





}
