package ejemplo00.aplicacion;

import java.util.List;

import ejemplo00.Cliente;

//Estos son los servicios (casos de uso) que expone la capa de presentación 
public interface ClienteService {
	public List<Cliente> obternerClientes();
	public Cliente obtenerCliente(int id);
	public void borrarCliente(int id);
	public void actualizarCliente(Cliente cli);
	public void insertar(Cliente cli);
}
