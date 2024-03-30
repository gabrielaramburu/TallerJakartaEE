package example00.interfaces.ws.soap;

import java.util.List;

import example00.aplicacion.PagoService;
import example00.dominio.Pago;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class PagoSOAP {

	@Inject
	private PagoService pagoService;
	
	@WebMethod
	@WebResult(name = "idPago")
	public int realizarPago(@WebParam(name = "monto") int monto) {
		int id = pagoService.realizarPago(monto);
		return id;
	}
	
	@WebMethod
	@WebResult(name = "pagos")
	public List<Pago> obtenerPagos() {
		return pagoService.obtenerPagos();
	}
}
