package org.tallerjava.moduloMonitoreo.interfase.evento.escuchar;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.tallerjava.moduloPeaje.interfase.evento.out.PeajeVehiculoNoEncontrado;

/**
 * Observese que este Modulo si esta acoplado con el módulo de Peaje.
 * De todas maneras, no perder de vista que el modulo Peaje no conoce a modulo de Monitoreo
 * Un nivel mayor de desacoplamiento lo podemos lograr con JMS
 */
@ApplicationScoped
public class ObserverPeajeVehiculoNoEncontrado {
    public void accept(@Observes PeajeVehiculoNoEncontrado event) {
        //en un futuro acá voy a tener que mostrar en una gráfica de error lo ocurrido
        System.out.println(event.getDescripcion());
    }
}
