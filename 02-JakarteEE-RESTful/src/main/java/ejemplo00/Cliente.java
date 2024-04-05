package ejemplo00;


public class Cliente {
	private int id;
	
	private String nombre;
	
	public Cliente() {
		
	}
	public Cliente(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Cliente (int id) {
		this.id = id;
	}

	//Los record en Java implementan el método equals utilicando todos los campos
	//En este caso estamos sobreescribiendo el método para que solo contemple el id
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + "]";
	}
	
	//Para que el binding automático funciones, la clase tiene que tener expuestos sus atributos
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
		

}
