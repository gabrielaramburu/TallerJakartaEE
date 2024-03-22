package ejemplo05;

import jakarta.enterprise.context.ApplicationScoped;

//Notese que no todos los objetos necesariamente tienen que ser manejados por el contenedor
public class Lenguaje {
	
	private int id;
	private String nombres;
	

	public Lenguaje(int id, String nombres) {
		this.id = id;
		this.nombres = nombres;
	}


	@Override
	public String toString() {
		return "Lenguaje [id=" + id + ", nombres=" + nombres + "]";
	}
	
	
	
}
