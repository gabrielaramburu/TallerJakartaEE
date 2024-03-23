package ejemplo04;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@EnableAutoWeld
@AddPackages(ServiciosClientes.class)
class Ejemplo04_a_Test {

	@Inject 
	//El contenedor injectará el decorador correspondiente
	private ServiciosClientes servicio;
	
	@Test
	@DisplayName ("Probando de decorar un objeto que lanza una exception cuando se ejecuta un método")
	void test() {
		 assertDoesNotThrow(() -> {
			 servicio.procesarPagoClientes();
	      });
		
	}

}
