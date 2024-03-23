package ejemplo05;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@EnableAutoWeld
@AddPackages(Traductor.class)
class Ejemplo05_a_Test {

	@Inject 
	private Traductor traductor;
	
	@Test
	@DisplayName ("Probando la ejecución de @PostConstruct")
	void test() {
		 for (Lenguaje lengu: traductor.lenguajesDisponibles()) {
			 System.out.println(lengu.toString());
		 }
		
	}

}
