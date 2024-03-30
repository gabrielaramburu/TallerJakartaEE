package client;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import example00.interfaces.ws.soap.Pago;
import example00.interfaces.ws.soap.PagoSOAPService;
import example00.interfaces.ws.soap.PagoSOAPcli;

/**
 * Este cliente utiliza el codigo generado por la herramienta wsconsume.sh 
 * 
 * ./wsconsume.sh -k <url del wsdl>
 *  
 */
class InvocarWSClient {

	@Test
	@DisplayName("Invocando a WS de pagos: obtener pagos")
	void obtenerPagos() {
		PagoSOAPService	service = new PagoSOAPService();
		PagoSOAPcli pagoPort = service.getPagoSOAPPort();
		
		for(Pago  pago: pagoPort.obtenerPagos().getItem()) {
			System.out.println("Pago " + pago.getId() + ", monto: " + pago.getMonto());
		}

	}
	
	
	@Test
	@DisplayName("Invocando a WS de pagos: realizar pagos")
	void realizarPago() {
		PagoSOAPService	service = new PagoSOAPService();
		PagoSOAPcli pagoPort = service.getPagoSOAPPort();
		
		pagoPort.realizarPago(890);
		System.out.println("Pago Realizado");

	}
	
	
}
