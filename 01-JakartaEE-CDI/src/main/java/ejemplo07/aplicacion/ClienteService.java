package ejemplo07.aplicacion;

import java.util.List;

import ejemplo07.dominio.Cliente;

public interface ClienteService {
	//Representan los casos de usos de mi aplicación
	//Se puede relacionar con la idea de interface del Sistema que se vio en Prog.Avanzada
	public void agregarCliente(String nombre);
	public void borrarCliente(int id);
	public List<Cliente> obtenerClientes();

}
