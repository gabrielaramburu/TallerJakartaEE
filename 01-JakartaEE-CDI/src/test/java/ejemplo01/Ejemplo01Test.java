package ejemplo01;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

//estas anotaciones me permiten utilizar el servicio (Jakarta CDI) sin prender el servidor
@EnableAutoWeld
@AddPackages(TarjetaDebito.class)

class Ejemplo01Test {

	//Esta anotación hace que CDI cree injecte una instancia de Factura
	//Tambien crea las instancias (resuelve las dependencias) que Factura necesite
	@Inject
	private Factura factura;
	
	
	@DisplayName ("Primer ejemplo de DI")
	@Test
	void test() {
		factura.pagar(105.0);
		//obervar la salida: el pago se realiza con tarjeta de Debito, única implementación
		//de la interface
	}

}
