package model.data.dao;

import model.Eleccion;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import java.util.ArrayList;

import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;
public class EleccionDAO {

    public static void registrarEleccion(DSLContext query, Eleccion eleccion){
        Table tablaEleccion= table(name("eleccion"));
        Field[] columnas = tablaEleccion.fields("nombreEleccion", "fechaEleccion","lugarEleccion");
        query.insertInto(tablaEleccion, columnas[0], columnas[1],columnas[2])
                .values(eleccion.getNombre(), eleccion.getFecha(),eleccion.getLugar())
                .execute();
    }

    // metodo para validar si una eleccion ya existe en la base de datos
    public static boolean validarExistenciaEleccion(DSLContext query,String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("eleccion")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        if(resultados.size()>=1){
            return true;
        }
        else{
            return false;
        }
    }



}
