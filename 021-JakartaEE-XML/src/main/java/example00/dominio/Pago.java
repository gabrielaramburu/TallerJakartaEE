package example00.dominio;

public class Pago {
	private int id;
	private int monto;
	
	public Pago(int id, int monto) {
		this.id = id;
		this.monto = monto;
	}
	
	public Pago() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", monto=" + monto + "]";
	}
	
	
	
}
