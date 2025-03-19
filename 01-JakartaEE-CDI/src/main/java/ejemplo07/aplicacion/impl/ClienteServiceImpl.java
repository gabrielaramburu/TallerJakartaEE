package ejemplo07.aplicacion.impl;

import java.util.List;

import ejemplo07.aplicacion.ClienteRepositorio;
import ejemplo07.aplicacion.ClienteService;
import ejemplo07.dominio.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

	//En la capa de servicios necesito acceder al repositorio
	//En un futuro voy a necesitar injectar otras funcionalidades de la plataforma
	//Tenga en cuenta lo siguiente: si bien en tiempo de ejecución el sentido de ejecución es 
	//la capa de aplicación llama a la capa de persistencia (infraestructura), en tiempo de compilación
	//es la capa de infraesructura la que depende de la capa de aplicación.
	//Esto es así ya que la interface ClienteRepositorio esta ubicacad en la capa de aplicación.
	
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
