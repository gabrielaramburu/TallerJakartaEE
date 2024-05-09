package org.tallerjava.moduloPeaje.dominio;

import lombok.Getter;

@Getter
public class Comun extends Tarifa{
    public Comun(double valor) {
        this.valor = valor;
    }
}
