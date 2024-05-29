package org.tallerjava.moduloGestion.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gestion_cuentaPrePaga")
public class PrePaga extends Cuenta{
    private double saldo;

    public PrePaga(double saldo, LocalDateTime fechaApertura) {
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.descripcion = "Cuenta PrePaga";
    }
    public void descontarSaldo(double importe) {
        this.saldo -= importe;
    }

    public void cargarSaldo(double importe) {
        this.saldo += importe;
    }
}
