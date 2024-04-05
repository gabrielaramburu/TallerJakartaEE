package api2.aplicacion;

import java.io.Serializable;

import api2.dominio.Contador;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;

//ApplicationScoped
//@RequestScoped
@SessionScoped
public class ContadorServiceImpl implements ContadorService, Serializable {

	private Contador contador;
	
	@PostConstruct
	private void creoContador() {
		contador = new Contador();
		contador.inicializar();
	}
	
	@Override
	public int incrementar() {
		contador.incrementar();
		return contador.getTotal();
	}

	@Override
	public void inicializar() {
		contador.inicializar();
	}

}
