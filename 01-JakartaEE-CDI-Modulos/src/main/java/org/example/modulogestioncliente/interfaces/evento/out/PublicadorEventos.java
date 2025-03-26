package org.example.modulogestioncliente.interfaces.evento.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class PublicadorEventos {
    @Inject
    private Event<EventoInformarNuevoVinculo> informarNuevoVinculoEvent;

    public void publicarNuevoVinculo(String matricula, String ci){
        informarNuevoVinculoEvent.fire(new EventoInformarNuevoVinculo(matricula, ci));
    }
}
