package ejemplo00.aplicacion.impl;

import java.util.ArrayList;
import java.util.List;

import ejemplo00.Cliente;
import ejemplo00.aplicacion.ClienteService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Implementación solo con fines demostrativos.

 */
@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
	List<Cliente> clientes;
	
	@PostConstruct
	private void inicializar() {
		System.out.println("Invocando PostConstruct");
		this.clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(1,"Luis"));
		clientes.add(new Cliente(2,"Mirta"));
	}
	
	@Override
	public List<Cliente> obternerClientes() {
		return clientes;
	}

	@Override
	public Cliente obtenerCliente(int id) {
		int indx = clientes.indexOf(new Cliente(id));
		return indx != -1? clientes.get(indx) : null;
	}

	@Override
	public void borrarCliente(int id) {
		clientes.remove(new Cliente(id));
	}

	@Override
	public void actualizarCliente(Cliente cli) {
		borrarCliente(cli.getId()); //los registros son objetos inmutables
		clientes.add(cli);
		
	}

	@Override
	public void insertar(Cliente cli) {
		clientes.add(cli);
		
	}

	
}
