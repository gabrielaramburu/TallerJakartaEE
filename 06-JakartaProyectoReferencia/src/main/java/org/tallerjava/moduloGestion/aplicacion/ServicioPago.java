package org.tallerjava.moduloGestion.aplicacion;

import org.tallerjava.moduloGestion.dominio.Cuenta;

import java.util.List;

public interface ServicioPago {
    public boolean realizarPrePago(int tag, double importe);
    public boolean realizarPostPago(int tag, double importe);

    public boolean esClienteTelepeaje(int tag);
}
