package application;

import domain.Cuenta;

public interface CuentaRepository {
	public Cuenta findById(int idCuenta);
	public void actualizar(Cuenta cuenta);
	public void crearCuenta(Cuenta cuenta);
	
}
