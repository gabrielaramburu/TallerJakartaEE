package org.tallerjava.moduloPeaje.aplicacion;

public interface ServicioPeaje {
    public boolean estaHabilitadoSincronico(int tag, String matricula);

    public void actualizarTarifaComun(double importe);
    public void actualizarTarifaPreferencial(double importe);
}
