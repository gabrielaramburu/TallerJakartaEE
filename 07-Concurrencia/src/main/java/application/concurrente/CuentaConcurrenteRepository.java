package application.concurrente;

import domain.CuentaConcurrente;

public interface CuentaConcurrenteRepository {
	public CuentaConcurrente findById(int idCuenta);
	public void actualizar(CuentaConcurrente cuenta);
	public void crearCuenta(CuentaConcurrente cuenta);
	
}
