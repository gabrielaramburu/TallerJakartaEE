package org.example.modulogestioncliente.dominio;

import lombok.Data;

@Data
public class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String matricula;

    public Vehiculo(int id, String marca, String modelo, String matricula) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }
}
