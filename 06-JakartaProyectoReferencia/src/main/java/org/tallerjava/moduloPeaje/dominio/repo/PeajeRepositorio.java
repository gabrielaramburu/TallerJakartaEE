package org.tallerjava.moduloPeaje.dominio.repo;

import org.tallerjava.moduloPeaje.dominio.Comun;
import org.tallerjava.moduloPeaje.dominio.Preferencial;
import org.tallerjava.moduloPeaje.dominio.Vehiculo;

/**
 * Eventualmente, si esta clase crece mucho, puedo tener más de un repositorip
 */
public interface PeajeRepositorio {
    public Vehiculo findByTag(int tag);
    public Vehiculo findByMatricula(String matricula);

    public Preferencial obtenerTarifaPreferencial();
    public Comun obtenerTarifaComun();
}
