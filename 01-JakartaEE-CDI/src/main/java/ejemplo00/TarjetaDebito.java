package ejemplo00;

public class TarjetaDebito implements MedioDePago {

	@Override
	public boolean pagar(double importe) {
		System.out.println("Pagando con Debito, total = " + importe);
		return true;
	}

}
