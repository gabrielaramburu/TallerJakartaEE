package org.tallerjava.moduloPeaje.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import org.tallerjava.moduloPeaje.dominio.*;
import org.tallerjava.moduloPeaje.dominio.repo.PeajeRepositorio;

@ApplicationScoped
public class PeajeRepositorioImpl implements PeajeRepositorio {
    //Esta clase por ahora no se usa ya que estoy ofreciendo mock al momento de realizar los test
    @Override
    public Vehiculo findByTag(int tag) {
       return null;
    }

    @Override
    public Vehiculo findByMatricula(String matricula) {
        return null;
    }

    @Override
    public Preferencial obtenerTarifaPreferencial() {
       return null;
    }

    @Override
    public Comun obtenerTarifaComun() {
       return null;
    }
}
