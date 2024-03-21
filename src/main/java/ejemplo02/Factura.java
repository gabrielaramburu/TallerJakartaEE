package ejemplo02;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Factura {
	
	@Inject
	//La siguiente anotación es un Calificador que le dice al contenedor
	//Que implementación utilizar
	@Debito
	private MedioDePago medioPago;


	public boolean pagar(Double importe) {
		System.out.println("Pagando factura...");
		return medioPago.pagar(importe);
	}
	
}
