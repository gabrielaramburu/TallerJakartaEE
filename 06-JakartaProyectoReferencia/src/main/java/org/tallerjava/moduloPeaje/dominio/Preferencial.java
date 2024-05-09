package org.tallerjava.moduloPeaje.dominio;

import lombok.Getter;


public class Preferencial extends Tarifa{
    public Preferencial(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }
}
