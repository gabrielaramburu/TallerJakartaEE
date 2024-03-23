package ejemplo03;

import static org.junit.jupiter.api.Assertions.fail;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ejemplo02.Factura;
import ejemplo02.MedioDePago;
import jakarta.inject.Inject;

@EnableAutoWeld
@AddPackages(MedioDePago.class)
@AddPackages(NotificadorPago.class)
class Ejemplo03 {

	@Inject
	private Factura factura;
	
	@Inject
	//Para satisfacer esta dependencia, el contenedor invocará el Producer
	//Ver clase Producer ejemplo03 NotificadorProducer
	private NotificadorPago notificador;
	
	@Test
	@DisplayName("DI usando Producers")
	void test() {
		factura.pagar(600.5);
		notificador.notificar(10, "Su pago fue realizado");
	}

}
