package ejemplo06;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ObservadorEventoA {
	 public void accept(@Observes Evento evento) {
	        System.out.println("Soy A: He recibido un evento: " + evento.getDescripcion());
	 }
}
