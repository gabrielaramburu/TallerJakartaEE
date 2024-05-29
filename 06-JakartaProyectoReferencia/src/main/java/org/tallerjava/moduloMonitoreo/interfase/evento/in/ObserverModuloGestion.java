package org.tallerjava.moduloMonitoreo.interfase.evento.in;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.tallerjava.moduloGestion.interfase.evento.out.GestionPagoCuentaPostPaga;
import org.tallerjava.moduloGestion.interfase.evento.out.GestionPagoCuentaPrePaga;
import org.tallerjava.moduloMonitoreo.infraestructura.RegistradorDeMetricas;

/**
 * Observese que este Modulo si esta acoplado con el módulo de Gestion (ya que conoce sus eventos)
 * Idem para cada modulo que lanza eventos
 *
 * Un nivel mayor de desacoplamiento lo podemos lograr con JMS
 *
 */
@ApplicationScoped
public class ObserverModuloGestion {
    private static final Logger log = Logger.getLogger(ObserverModuloGestion.class);

    @Inject
    private RegistradorDeMetricas register;

    public void accept(@Observes GestionPagoCuentaPrePaga event) {
        log.infof("Evento procesado: GestionPagoCuentaPrePaga: %s", event.getEvento());
        register.incrementarCounter(RegistradorDeMetricas.GESTION_COUNTER_PRE_PAGO);
    }
    public void accept(@Observes GestionPagoCuentaPostPaga event) {
        log.infof("Evento procesado: GestionPagoCuentaPostPaga: %s", event.getEvento());
       register.incrementarCounter(RegistradorDeMetricas.GESTION_COUNTER_POST_PAGO);
    }
}
