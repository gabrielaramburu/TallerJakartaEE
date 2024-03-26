package ejemplo00;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Ejemplo00SinDI {

	@DisplayName("Prueba unitario de pago de factura, sin ID")
	@Test
	void pagarFacturaTest() {
		List<Producto> productos = new ArrayList<Producto>();
		productos.add(new Producto("Tomate",10));
		productos.add(new Producto("Papa",15));
		productos.add(new Producto("Manzana", 20));
		
		Factura factura = new Factura(productos, new TarjetaDebito());
		assertTrue(factura.pagar());
		

	}

}
