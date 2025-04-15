package application;

import domain.Cuenta;
import domain.CuentaConcurrente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CuentaServicesImpl implements CuentaServices{
	
	@Inject
	private CuentaRepository cuentaRepo;
	
	@Override
	@Transactional
	public void acreditar(int idCuenta, int importe) {
		Cuenta cuenta = cuentaRepo.findById(idCuenta);
		if (cuenta == null) {
			System.out.println("Creo cuenta ya que no existe y le acredito un saldo inicial");
			Cuenta c = new Cuenta(idCuenta, importe);
			
			cuentaRepo.crearCuenta(c);
			
		} else {
			System.out.println("Acreditando a cuenta: " + idCuenta + ", importe: " + importe);
			cuenta.acreditar(importe);
			cuentaRepo.actualizar(cuenta);
		}
		
	}

	@Override
	public int consultarSaldo(int idCuenta) {
		Cuenta cuenta = cuentaRepo.findById(idCuenta);
		if (cuenta != null) {
			int saldo  = cuenta.getSaldo();
			System.out.println("Cuenta existe, retorno saldo = " + saldo);
			return saldo;
		} else {
			System.out.println("Cuenta no existe");
			return 0;
		}
	}

	@Override
	@Transactional
	public void inicializar(int idCuenta) {
		Cuenta cuenta = cuentaRepo.findById(idCuenta);
		if (cuenta != null) {
			cuenta.inicializar();
			cuentaRepo.actualizar(cuenta);
			System.out.println("Cuenta inicializada");
		}
	}
	
	

}
