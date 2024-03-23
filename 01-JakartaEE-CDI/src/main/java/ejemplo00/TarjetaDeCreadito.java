package ejemplo00;

public class TarjetaDeCreadito implements MedioDePago {

	@Override
	public boolean pagar(double importe) {
		System.out.println("Pagando con Credito, total = " + importe);
		return true;
	}

}
