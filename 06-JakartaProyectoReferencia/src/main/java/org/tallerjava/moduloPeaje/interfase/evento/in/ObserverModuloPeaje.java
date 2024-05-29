package org.tallerjava.moduloPeaje.interfase.evento.in;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.tallerjava.moduloGestion.interfase.evento.out.GestionNuevoVehiculo;
import org.tallerjava.moduloGestion.interfase.evento.out.GestionPagoCuentaPostPaga;
import org.tallerjava.moduloGestion.interfase.evento.out.GestionPagoCuentaPrePaga;
import org.tallerjava.moduloMonitoreo.infraestructura.RegistradorDeMetricas;
import org.tallerjava.moduloPeaje.aplicacion.ServicioPeaje;
import org.tallerjava.moduloPeaje.dominio.Identificador;
import org.tallerjava.moduloPeaje.dominio.Nacionalidad;
import org.tallerjava.moduloPeaje.dominio.Vehiculo;

@ApplicationScoped
public class ObserverModuloPeaje {
    private static final Logger log = Logger.getLogger(ObserverModuloPeaje.class);

    @Inject
    private ServicioPeaje servicioPeaje;

    public void accept(@Observes GestionNuevoVehiculo event) {
        log.infof("Evento procesado: GestionNuevoVehiculo: %s", event.toString());
        Identificador identificador = new
                Identificador(event.getMatricula(), event.getTag());
        Vehiculo vehiculo = new Vehiculo(
                identificador,
                event.getMarca(),
                event.getModelo(),
                Nacionalidad.getById(event.getNacionalidad()));

        servicioPeaje.altaVehiculo(vehiculo);
    }

}
