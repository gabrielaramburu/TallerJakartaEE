package ejemplo07.dominio;

public class Cliente {
	private int id;
	private String nombre;
	
	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + "]";
	}
	
	
	//otros atributos y lógica de negocio
	
}
