package api2.dominio;

public class Contador {
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Contador(int total) {
		super();
		this.total = total;
	}
	
	public Contador() {
		total = 0;
	}
	
	public void incrementar() {
		total++;
	}
	
	public void inicializar() {
		total = 0;
	}
}
