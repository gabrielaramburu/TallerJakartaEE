package org.tallerjava.moduloGestion.interfase.evento.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import org.tallerjava.moduloGestion.dominio.Vehiculo;
import org.tallerjava.moduloGestion.interfase.remota.rest.VehiculoDTO;
import org.tallerjava.moduloPeaje.interfase.evento.out.PeajeVehiculoNoEncontrado;

@ApplicationScoped
public class PublicadorEventoGestion {
    @Inject
    private Event<GestionPagoCuentaPrePaga> pagoCuentaPrePaga;

    @Inject
    private Event<GestionPagoCuentaPostPaga> pagoCuentaPostPaga;

    @Inject
    private Event<GestionNuevoVehiculo> nuevoVehiculo;

    public void publicarPagoCuentaPrePaga(String mensaje){
        pagoCuentaPrePaga.fire(new GestionPagoCuentaPrePaga(mensaje));
    }

    public void publicarPagoCuentaPostPaga(String mensaje){
        pagoCuentaPostPaga.fire(new GestionPagoCuentaPostPaga(mensaje));
    }

    public void publicarNuevoVehiculo(Vehiculo vehiculo){
        GestionNuevoVehiculo evento = new GestionNuevoVehiculo(
                (int)vehiculo.getTag(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getMatricula(),
                vehiculo.getNacionalidad().getId()
        );

        nuevoVehiculo.fire(evento);
    }
}
