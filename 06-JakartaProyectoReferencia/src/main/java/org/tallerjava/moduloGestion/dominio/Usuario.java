package org.tallerjava.moduloGestion.dominio;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Usuario {
    protected long id;
    protected String nombre;
    protected String email;
    protected List<Vehiculo> vehiculosAsociados;
    protected ClienteTelepeaje clienteTelepeaje;

    public abstract boolean soyNacional();

}
