package ejemplo01;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@EnableAutoWeld
@AddPackages(TarjetaDebito.class)

class Ejemplo01Test {

	@Inject
	private Factura factura;
	
	
	@DisplayName ("Primer ejemplo de DI")
	@Test
	void test() {
		factura.pagar(100.0);
	}

}
