package org.example.modulogestioncliente.dominio;

import lombok.Data;

import java.util.List;
@Data
public class Cliente {
    private long id;
    private String nombre;
    private String email;
    private String cedula;

    private List<Vehiculo> vehiculos;


    public void vincularVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

}
