package ejemplo06;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
//Este observer está interesado en escuchar eventos de tipo Evento.

//Cada vez que el notificador lanza un evento, el contenedor ejectuta este método
	//En realidad cualquier método que esté anotado con @Observer 
	//Notar que solo se responderan a eventos de tipo Evento
	//Notar que no existe acoplamiento entre el publisher y el suscriber
public class ObservadorEventoA {
	 public void acceptar(@Observes Evento evento) {
	        System.out.println("Soy A: He recibido un evento: " + evento.getDescripcion());
	 }
}
