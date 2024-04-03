package api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Buzon {
	private List<Mensaje> mensajes;
	
	@PostConstruct
	private void inicializar() {
		mensajes = new ArrayList<Mensaje>();
		mensajes.add(new Mensaje(1, "hola mundo", new Date()));
	}
	
	public void agregar(String mensaje) {
		mensajes.add(new Mensaje(nuevoId(), mensaje, new Date()));
	}
	
	public List<Mensaje> listar() {
		return mensajes;
	}
	
	private int nuevoId() {
		return mensajes.size() + 1;
	}
}
