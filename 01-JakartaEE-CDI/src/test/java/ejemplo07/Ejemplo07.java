package ejemplo07;

import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ejemplo07.aplicacion.ClienteRepositorio;
import ejemplo07.aplicacion.ClienteService;
import ejemplo07.aplicacion.impl.ClienteServiceImpl;
import ejemplo07.dominio.Cliente;
import ejemplo07.infraestructura.persistencia.JpaClienteRepositorio;
import jakarta.inject.Inject;

@EnableAutoWeld
@AddPackages(ClienteServiceImpl.class)
@AddPackages(JpaClienteRepositorio.class)
class Ejemplo07 {

	//desde la capa superior necesito inyectar los servicios de la capa de Aplicación
	@Inject
	private ClienteService clienteService;
	
	//Este test estaría representando la capa de Interfaces
	@Test
	@DisplayName("Recuperar clientes")
	void test() {
		for(Cliente cli: clienteService.obtenerClientes()) {
			System.out.println(cli.toString());
		}
		
		clienteService.agregarCliente("Pepe");
		
		for(Cliente cli: clienteService.obtenerClientes()) {
			System.out.println(cli.toString());
		}
	}
	
	

}
