package org.tallerjava.moduloPeaje.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import org.tallerjava.moduloPeaje.dominio.*;
import org.tallerjava.moduloPeaje.dominio.repo.PeajeRepositorio;

@ApplicationScoped
public class PeajeRepositorioImpl implements PeajeRepositorio {
    @Override
    public Vehiculo findByTag(int tag) {
        Vehiculo vehiculo = new Vehiculo(1,
                new Identificador(1,"baa 4444", 10001),
                 "ford", "fiesta", Nacionalidad.NACIONAL);

        return vehiculo;
    }

    @Override
    public Vehiculo findByMatricula(String matricula) {
        return null;
    }

    @Override
    public Preferencial obtenerTarifaPreferencial() {
        return new Preferencial(100);
    }

    @Override
    public Comun obtenerTarifaComun() {
        return new Comun(150);
    }
}
