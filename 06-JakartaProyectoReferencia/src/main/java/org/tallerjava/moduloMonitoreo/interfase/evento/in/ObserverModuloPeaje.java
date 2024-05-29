package org.tallerjava.moduloMonitoreo.interfase.evento.in;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.tallerjava.moduloMonitoreo.infraestructura.RegistradorDeMetricas;
import org.tallerjava.moduloPeaje.interfase.evento.out.PeajePagoSucive;
import org.tallerjava.moduloPeaje.interfase.evento.out.PeajeVehiculoNoEncontrado;

/**
 * Observese que este Modulo si esta acoplado con el módulo de Peaje (ya que conoce sus eventos)
 * Idem para cada modulo que lanza eventos
 *
 * Un nivel mayor de desacoplamiento lo podemos lograr con JMS
 *
 */
@ApplicationScoped
public class ObserverModuloPeaje {
    private static final Logger log = Logger.getLogger(ObserverModuloPeaje.class);

    @Inject
    private RegistradorDeMetricas register;

    public void accept(@Observes PeajeVehiculoNoEncontrado event) {
        log.infof("Evento procesado: PeajeVehiculoNoEncontrado: %s", event.getDescripcion());
       register.incrementarCounter(RegistradorDeMetricas.PEAJE_COUNTER_VEHICULO_NO_ENCONTRADO);
    }

    public void accept(@Observes PeajePagoSucive event) {
        log.infof("Evento procesado: PeajePagoSucive: %s", event.getDescripcion());
        register.incrementarCounter(RegistradorDeMetricas.PEAJE_COUNTER_PAGO_SUCIVE);
    }
}
