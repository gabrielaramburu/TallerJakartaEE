package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;


/**
 * Hago otra clase para tener ejemplos sin control de concurrencia y con control de concurrencia
 */
@Entity
public class CuentaConcurrente {
	@Id
	private int idCuenta;
	private int saldo;
	
	@Version //esto se utilza para decirle al frmawork que implemente bloqueo optimista de forma automática
	private int version;
	
	private int versionManual; //eso se utiliza par implementar bloqueo optimista manual
	
	public int getVersionManual() {
		return versionManual;
	}

	public void setVersionManual(int versionManual) {
		this.versionManual = versionManual;
	}

	public CuentaConcurrente() {
		
	}
	
	public CuentaConcurrente(int id, int saldo) {
		this.idCuenta = id;
		this.saldo = saldo;
	}
	
	public int getSaldo() {
		return this.saldo;
	}
	
	public void inicializar() {
		this.saldo = 0;
	}
	
	public int getVersion() { 
		return version; 
	}
	
	public void setVersion(Integer v) {
		this.version = v;
	}
	
	public void acreditar(int importe) {
		this.saldo = this.saldo + importe;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	
}
