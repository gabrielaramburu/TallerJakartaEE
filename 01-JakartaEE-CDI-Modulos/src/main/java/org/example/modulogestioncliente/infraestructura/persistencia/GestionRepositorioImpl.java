package org.example.modulogestioncliente.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.modulogestioncliente.aplicacion.repositorio.GestionRepositorio;
import org.example.modulogestioncliente.dominio.Cliente;
import org.example.modulogestioncliente.dominio.Vehiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementación muy básica de un repositorio en memoria
 */
@ApplicationScoped
public class GestionRepositorioImpl implements GestionRepositorio {
    Map<Long, Cliente> clientes = new HashMap<>();

    Map<Long, List<Vehiculo>>  clientesVehiculos = new HashMap<>();

    @Override
    public Cliente findById(Long id) {
        return clientes.get(id);
    }

    @Override
    public void save(Cliente cliente) {
        if (!clientes.containsKey(cliente.getId())) {
            clientes.put(cliente.getId(), cliente);
        }
    }

    @Override
    public void vincularVehiculo(Cliente cliente, Vehiculo vehiculo) {
        if (clientesVehiculos.containsKey(cliente.getId())) {
            List<Vehiculo> vehiculos = clientesVehiculos.get(cliente.getId());
            if (vehiculos == null) {
                vehiculos = new ArrayList<>();
                vehiculos.add(vehiculo);
                clientesVehiculos.put(cliente.getId(), vehiculos);
            } else {
                vehiculos.add(vehiculo);
            }
        }
    }
}
