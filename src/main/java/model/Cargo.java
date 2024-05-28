package model;

public enum Cargo {

    ALCALDE("Alcalde"), GOBERNADOR("Gobernador");

    private String nombre;

    private Cargo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }





}
