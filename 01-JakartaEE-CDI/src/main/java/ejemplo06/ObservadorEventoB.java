package ejemplo06;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ObservadorEventoB {
	
	//Cada vez que el notificador lanza un evento, el contenedor ejectuta este método
	//En realidad cualquier método que esté anotado con @Observer 
	//Notar que solo se responderan a eventos de tipo Evento
	//Notar que no exist acoplamiento entre el publisher y el suscriber
	 public void accept(@Observes Evento evento) {
	        System.out.println("Soy B: He recibido un evento: " + evento.getDescripcion());
	 }
}
