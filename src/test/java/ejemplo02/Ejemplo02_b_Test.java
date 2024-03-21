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
class Ejemplo02_b_Test {

	@Inject
	
	//Con esta anotación le pedimos al contendor que nos de todas las implementaciones
	//Eventualemnte podríamos programar que nuestro aplicación determine siguiendo cierta
	//lógica, que implementación usar.
	@Any
	private Instance<MedioDePago> mediosDePagos;
	

	@DisplayName("DI cuando tengo más de una implementación: mostrar implementaciones")
	@Test
	void testMostrarTotasLasImplementaciones() {
		for (MedioDePago medioP: mediosDePagos) {
			System.out.println(medioP.getClass().getTypeName());
		}
	}

}
