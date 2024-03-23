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
class Ejemplo02_a_Test {
	
	@Inject
	private Factura factura;
	
	@DisplayName("DI cuando tengo más de una implementación: uso de Qualifiers")
	@Test
	void test() {
		factura.pagar(200.0);
		//Observar en la consola que el pago se realiza con tarjeta de Debito
		//ya que así lo indicamos en ejemplo02.Factura
		
		//Resolvimos el problema de determinar que interface
		//pero todavía lo resolvemos por código.
			
	}



}
