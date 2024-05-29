package org.tallerjava.moduloPeaje.interfase.evento.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEvento {
    @Inject
    private Event<PeajeVehiculoNoEncontrado> vehiculoNoEncontrado;

    @Inject
    private Event<PeajePagoSucive> pagoSuciveEvento;

    public void publicarVehiculoNoEncontrado(String mensaje){
        vehiculoNoEncontrado.fire(new PeajeVehiculoNoEncontrado(mensaje));
    }

    public void publicarPagoSucive(String mensaje){
        pagoSuciveEvento.fire(new PeajePagoSucive(mensaje));
    }
}
