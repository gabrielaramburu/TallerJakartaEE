package org.example.modulogestioncliente.aplicacion.repositorio;

import org.example.modulogestioncliente.dominio.Cliente;
import org.example.modulogestioncliente.dominio.Vehiculo;

public interface GestionRepositorio {
    public Cliente findById(Long id);
    public void save(Cliente cliente);
    public void vincularVehiculo(Cliente cliente, Vehiculo vehiculo);

}
