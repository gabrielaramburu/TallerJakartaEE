package application.concurrente;

public interface CuentaConcurrenteServices {
	public void acreditarConcurrente(int idCuenta, int importe);
	public int consultarSaldo(int idCuenta);
	public void inicializar(int idCuenta);
	
}
