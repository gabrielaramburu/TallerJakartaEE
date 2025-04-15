package application.concurrente;

import domain.CuentaConcurrente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@ApplicationScoped
public class CuentaConcurrenteServicesImpl implements CuentaConcurrenteServices{
	
	@Inject
	private CuentaConcurrenteRepository cuentaRepo;
	
	
	@Override
	@Transactional
	public void acreditarConcurrente(int idCuenta, int importe) {
		
			CuentaConcurrente cuenta = cuentaRepo.findById(idCuenta);
			if (cuenta == null) {
				System.out.println("Creo cuentaConcurrente ya que no existe y le acredito un saldo inicial");
				CuentaConcurrente c = new CuentaConcurrente(idCuenta, importe);
				
				cuentaRepo.crearCuenta(c);
				
			} else {
				
					System.out.println("Acreditando a cuentaC: " + idCuenta + ", importe: " + importe);
					cuenta.acreditar(importe);
					cuentaRepo.actualizar(cuenta);
	
				
			}
		
		
		
	}

	@Override
	@Transactional
	public int consultarSaldo(int idCuenta) {
		CuentaConcurrente cuenta = cuentaRepo.findById(idCuenta);
		if (cuenta != null) {
			int saldo  = cuenta.getSaldo();
			System.out.println("Cuenta Concurrente existe, retorno saldo = " + saldo);
			return saldo;
		} else {
			System.out.println("Cuenta Concurrente no existe");
			return 0;
		}
	}

	@Override
	@Transactional
	public void inicializar(int idCuenta) {
		CuentaConcurrente cuenta = cuentaRepo.findById(idCuenta);
		if (cuenta != null) {
			cuenta.inicializar();
			cuentaRepo.actualizar(cuenta);
			System.out.println("Cuenta Concurrente inicializada");
		}
	}

	
	
	

}
