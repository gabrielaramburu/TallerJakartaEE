package application.concurrente;

public interface CuentaConcurrenteServices {
	public enum ResultadoAcreditacion {
		ACREDITACION_OK,
		ACREDITACION_ERROR
	}
	public ResultadoAcreditacion acreditarConcurrente(int idCuenta, int importe);
	public int consultarSaldo(int idCuenta);
	public void inicializar(int idCuenta);
	
}
