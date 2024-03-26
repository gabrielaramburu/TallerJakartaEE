package ejemplo00.aplicacion;

import java.util.List;

import ejemplo00.Cliente;

public interface ClienteService {
	public List<Cliente> obternerClientes();
	public Cliente obtenerCliente(int id);
	public void borrarCliente(int id);
	public void actualizarCliente(Cliente cli);
	public void insertar(Cliente cli);
}
