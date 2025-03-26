package org.example.modulogestioncliente.aplicacion;

import org.example.modulogestioncliente.dominio.Cliente;
import org.example.modulogestioncliente.dominio.Vehiculo;

public interface ServicioGestion {
    public void altaClienteTelepeaje(Cliente cli);
    public void vincularVehiculo(Cliente cli, Vehiculo v);
}
