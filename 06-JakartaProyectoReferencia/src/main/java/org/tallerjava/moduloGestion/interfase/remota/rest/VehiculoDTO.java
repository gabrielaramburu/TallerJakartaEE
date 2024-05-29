package org.tallerjava.moduloGestion.interfase.remota.rest;

import lombok.Data;
import org.tallerjava.moduloGestion.dominio.Nacionalidad;
import org.tallerjava.moduloGestion.dominio.Vehiculo;

@Data
public class VehiculoDTO {
    private long idCliente;
    private int tag;
    private String marca;
    private String modelo;
    private String matricula;
    private int nacionalidad;

    public Vehiculo buildVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMarca(this.marca);
        vehiculo.setModelo(this.modelo);
        vehiculo.setMatricula(this.matricula);
        Nacionalidad nacio =
                this.nacionalidad == Nacionalidad.EXTRANJERO.getId()?Nacionalidad.EXTRANJERO:Nacionalidad.NACIONAL;
        vehiculo.setNacionalidad(nacio);
        vehiculo.setTag(this.tag);
        return vehiculo;
    }
}
