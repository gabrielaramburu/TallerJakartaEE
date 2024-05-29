package org.tallerjava.moduloGestion.dominio;

public enum Nacionalidad {
    NACIONAL(1),
    EXTRANJERO(2);

    private int id;
    Nacionalidad(int id) { this.id = id; }
    public int getId() { return id; }

    public static Nacionalidad getById(int id) {
        switch (id) {
            case 1:
                return NACIONAL;
            case 2:
                return EXTRANJERO;
            default:
                throw new IllegalArgumentException("Nacionalidad invalida");
        }
    }
}
