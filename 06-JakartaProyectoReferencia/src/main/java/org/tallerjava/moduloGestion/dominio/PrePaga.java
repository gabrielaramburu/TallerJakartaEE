package org.tallerjava.moduloGestion.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gestion_cuentaPrePaga")
public class PrePaga extends Cuenta{

    private double saldo;

    public void descontarSaldo(double importe) {
        this.saldo -= importe;
    }

    public void cargarSaldo(double importe) {
        this.saldo += importe;
    }
}
