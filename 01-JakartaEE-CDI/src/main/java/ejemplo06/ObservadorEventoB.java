package ejemplo06;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

//puedo tener muchos interesados (observers) queriendo hacer algo cada vez que un evento 
//de tipo Evento se lance
@ApplicationScoped
public class ObservadorEventoB {
	
	
	 public void accept(@Observes Evento evento) {
	        System.out.println("Soy B: He recibido un evento: " + evento.getDescripcion());
	 }
}
