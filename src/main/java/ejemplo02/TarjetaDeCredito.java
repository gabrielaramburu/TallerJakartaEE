package ejemplo02;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
//Esta implementación, está calificada como Credito
@Credito
public class TarjetaDeCredito implements MedioDePago {

	@Override
	public boolean pagar(double importe) {
		System.out.println("Pagando con Credito, total = " + importe);
		return true;
	}

}
