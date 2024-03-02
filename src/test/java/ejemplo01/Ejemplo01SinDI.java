package ejemplo01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Ejemplo01SinDI {

	private Factura factura;
	
	@Test
	@DisplayName ("Probando pago Factura sin usar DI")
	void test() {
		factura = new Factura(new TarjetaDebito());
		factura.pagar(100.0);
	}

}
