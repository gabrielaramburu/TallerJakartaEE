package org.tallerjava.moduloGestion.aplicacion;

import org.tallerjava.moduloGestion.dominio.Vehiculo;
import org.tallerjava.moduloGestion.dominio.usuario.Usuario;

public interface ServicioGestion {
    public boolean realizarPrePago(int tag, double importe);
    public boolean realizarPostPago(int tag, double importe);

    public boolean esClienteTelepeaje(int tag);

    public long altaClienteTelepeaje(Usuario usuario);
    public double cargarSaldo(long idUsuario, double importe);

    public boolean vincularVehiculo(Vehiculo vehiculo, long idCliente);
}
