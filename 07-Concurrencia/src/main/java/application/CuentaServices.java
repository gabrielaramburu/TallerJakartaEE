package application;

public interface CuentaServices {
	public void acreditar(int idCuenta, int importe);
	public int consultarSaldo(int idCuenta);
	public void inicializar(int idCuenta);
	
}
