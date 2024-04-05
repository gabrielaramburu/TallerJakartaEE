package ejemplo01;

import java.util.List;

import ejemplo00.Cliente;
import ejemplo00.aplicacion.impl.ClienteServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Ejemplo de API con estilo rpc
 */
@ApplicationScoped
@Path("/clientes")
public class ClienteRPC {

	@Inject
	private ClienteServiceImpl clienteService;
	
	/**
	 * curl -v http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes/obtenerClientes
	 * 
	 * @return
	 */
	@GET
	@Path("/obtenerClientes")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Cliente> obtenerClientes() {
		System.out.println("Retornando todos los clientes");
		return clienteService.obternerClientes();
	}
	
	
	/**
	 * Observar como la funcionalidad invocada en la capa de aplicación es la misma
	 * Lo que cambia es el estilo de la API:
	 * 		sigue siendo una API remota REST pero con estilo RPC (remote procedure call)
	 * 		podemos decir que no es RESTful
	 * 
	 * curl -v http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes/getCliente?id=1
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getCliente")
	@Produces({MediaType.APPLICATION_JSON})
	public Cliente obtenerCliente(@QueryParam("id") int id) {
		System.out.println("Invocando obtenerCliente con id:" + id);
		
		return clienteService.obtenerCliente(id);
	}
	
	/**
	 * curl -v -X POST  http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes/borrarCliente?id=2
	 * 
	 * @param id
	 */
	@POST //no tengo porque respetar la interface de http
	@Path("/borrarCliente")
	@Produces({MediaType.APPLICATION_JSON})
	public void borrarCliente(@QueryParam("id") int id) {
		System.out.println("Invocando borrarCliente con id:" + id);
		
		clienteService.borrarCliente(id);
	}
	
}
