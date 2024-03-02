package ejemplo02;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Factura {
	
	@Inject
	@Debito
	private MedioDePago medioPago;


	public boolean pagar(Double importe) {
		System.out.println("Pagando factura...");
		return medioPago.pagar(importe);
	}
	
}
