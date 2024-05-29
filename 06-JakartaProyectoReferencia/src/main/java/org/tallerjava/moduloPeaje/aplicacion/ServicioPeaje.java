package org.tallerjava.moduloPeaje.aplicacion;

import org.tallerjava.moduloPeaje.dominio.Vehiculo;

public interface ServicioPeaje {
    public boolean estaHabilitadoSincronico(int tag, String matricula);

    public void actualizarTarifaComun(double importe);
    public void actualizarTarifaPreferencial(double importe);

    void altaVehiculo(Vehiculo vehiculo);
}
