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
		pulicadorEvento.publicarEvento("Algo nuevo ha sucedido");
	}

}
