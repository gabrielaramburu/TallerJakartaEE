package ejemplo02;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

@ApplicationScoped
//Esta implementación está Calificada como Debito
@Debito
public class TarjetaDebito implements MedioDePago {

	@Override
	public boolean pagar(double importe) {
		System.out.println("Pagando con Debito, total = " + importe);
		return true;
	}

}
