package org.tallerjava.moduloPeaje.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehiculo {
    private long id;
    private Identificador identificador;
    private String marca;
    private String modelo;
    private Nacionalidad nacionalidad;

    public boolean nacional() {
        return nacionalidad == Nacionalidad.NACIONAL?true:false;
    }
}
