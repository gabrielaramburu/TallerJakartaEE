package org.tallerjava.moduloGestion.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrePaga extends Cuenta{
    private double saldo;

    public void descontarSaldo(double importe) {
        this.saldo -= importe;
    }
}
