package ejemplo06;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@EnableAutoWeld
@AddPackages(Evento.class)
class Ejemplo06Test {

	@Inject 
	private PublicadorEvento pulicadorEvento;
	
	@Test
	void test() {
		//es muy importe notar, que no está garantizado el orden en que los observadores reciben la
		//notificación. No puedo programar mi aplicación pensando que los observadores van a recibir 
		//la notificación en un órden específico.
		pulicadorEvento.publicarEvento("Algo nuevo ha sucedido");
	}

}
