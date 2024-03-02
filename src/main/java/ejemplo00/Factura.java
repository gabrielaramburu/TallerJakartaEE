package ejemplo00;

import java.util.List;

public class Factura {
	private List<Producto> productos;
	
	private MedioDePago medioPago;
	
	
	public Factura(List<Producto> productos, MedioDePago medioPago) {
		super();
		this.productos = productos;
		this.medioPago = medioPago;
	}

	public boolean pagar() {
		double importe = this.calcularImporte();
		return medioPago.pagar(importe);
	}
	
	public double calcularImporte() {
		double total = 0;
		for (Producto producto: productos){
			total= total + producto.getPrecio();
		}
		return total;
	}
}
