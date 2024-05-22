package org.tallerjava.moduloPeaje.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "peaje_Vehiculo") //manualmente establezco el nombre de la tabla
public class Vehiculo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded //los atributos de este objeto serán incluido en la tabla Vehículo.
    private Identificador identificador;

    private String marca;
    private String modelo;
    private Nacionalidad nacionalidad;

    public Vehiculo() {}

    public boolean nacional() {
        return nacionalidad == Nacionalidad.NACIONAL?true:false;
    }
}
