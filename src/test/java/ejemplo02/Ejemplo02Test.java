package ejemplo02;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ejemplo02.MedioDePago;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@EnableAutoWeld
@AddPackages(MedioDePago.class)
class Ejemplo02Test {
	
	@Inject
	private Factura factura;
	
	@Inject
	@Any
	private Instance<MedioDePago> mediosDePagos;
	
	@DisplayName("DI cuando tengo más de una implementación: uso de Qualifiers")
	@Test
	void test() {
		factura.pagar(100.0);
	}

	@DisplayName("DI cuando tengo más de una implementación: mostrar implementaciones")
	@Test
	void testMostrarTotasLasImplementaciones() {
		for (MedioDePago medioP: mediosDePagos) {
			System.out.println(medioP.getClass().getName());
		}
	}

}
