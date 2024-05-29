package org.tallerjava.moduloGestion.interfase.evento.out;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GestionNuevoVehiculo {
    //no uso VehiculoDTO para maneter bajo el acoplamiento
    //de lo contrario el modulo de Peaje que es quien va a escuchar este evento
    //va a tener una dependencia transitiva con el DTO
    private int tag;
    private String marca;
    private String modelo;
    private String matricula;
    private int nacionalidad;
}
