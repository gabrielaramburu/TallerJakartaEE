package org.example.modulogestioncliente.aplicacion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.modulogestioncliente.aplicacion.repositorio.GestionRepositorio;
import org.example.modulogestioncliente.dominio.Cliente;
import org.example.modulogestioncliente.dominio.Vehiculo;
import org.example.modulogestioncliente.interfaces.evento.out.PublicadorEventos;

@ApplicationScoped
public class ServicioGestionImpl implements ServicioGestion {
    @Inject
    private PublicadorEventos publicadorEventos;

    @Inject
    private GestionRepositorio repositorioGestion;


    @Override
    public void altaClienteTelepeaje(Cliente cli) {
        Cliente cliente = repositorioGestion.findById(cli.getId());
        if (cliente == null) {
            repositorioGestion.save(cli);
        } else {
            //error
            //TODO, por simplicidad no se implementa manejo de errores
        }
    }

    @Override
    public void vincularVehiculo(Cliente cli, Vehiculo v) {
        repositorioGestion.vincularVehiculo(cli, v);
        publicadorEventos.publicarNuevoVinculo(v.getMatricula(), cli.getCedula());
    }
}
