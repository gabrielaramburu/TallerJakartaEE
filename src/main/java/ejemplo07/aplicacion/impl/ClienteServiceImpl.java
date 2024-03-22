package ejemplo07.aplicacion.impl;

import java.util.List;

import ejemplo07.aplicacion.ClienteService;
import ejemplo07.dominio.Cliente;
import ejemplo07.dominio.ClienteRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

	//En la capa de servicios necesito acceder al repositorio
	//En un futuro voy a necesitar injectar otras funcionalidades de la plataforma
	
	@Inject
	private ClienteRepositorio clienteRepositorio;
	
	@Override
	public void agregarCliente(String nombre) {
		System.out.println("Agregando cliente: " + nombre);
		
		//Necesito hacer new de objetos nuevos
		Cliente clienteNuevo = new Cliente(nombre);
		clienteRepositorio.agregar(clienteNuevo);
	}

	@Override
	public void borrarCliente(int idi) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> obtenerClientes() {
		System.out.println("Recuperando todos los clientes ");
		
		return clienteRepositorio.findAll();
	}

}
