package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;


@Entity
public class Cuenta {
	@Id
	private int idCuenta;
	private int saldo;
	
	public Cuenta() {
		
	}
	
	public Cuenta(int id, int saldo) {
		this.idCuenta = id;
		this.saldo = saldo;
	}
	
	public int getSaldo() {
		return this.saldo;
	}
	
	public void inicializar() {
		this.saldo = 0;
	}
	
	
	public void acreditar(int importe) {
		this.saldo = this.saldo + importe;
	}
	
}
