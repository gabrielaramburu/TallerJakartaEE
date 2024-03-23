package ejemplo01;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
//Esta anotación le dice a CDI que solo existirá una instancia de Factura
@ApplicationScoped
public class Factura {
	
	@Inject
	private MedioDePago medioPago;
	
	public Factura() {
		
	}

	public Factura(MedioDePago medioPago) {
		super();
		this.medioPago = medioPago;
	}

	public boolean pagar(Double importe) {
		System.out.println("Pagando factura...");
		return medioPago.pagar(importe);
	}
	
}
