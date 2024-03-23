package ejemplo03;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

@ApplicationScoped
public class NotificadorProducer {
	//esto tiene más sentido remplazarlo por una variable de ambiente
	private final static boolean  AMBIENTE_TESTING = false;

	//El contenedor siempre que alguien quiera injectar una NotificadorPago
	//va a llamar a este método
	@Produces
	public NotificadorPago obtenerNotificador() {
		NotificadorPago notificador = null;
		if (AMBIENTE_TESTING) {
			notificador = new NotificadorTesting();
		} else {
			notificador = new NotificadorProduccionMail();
		}
		
		return notificador;
	}
}
