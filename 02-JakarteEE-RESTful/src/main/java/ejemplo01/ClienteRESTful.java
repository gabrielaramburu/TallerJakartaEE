package ejemplo01;

import java.util.List;

import ejemplo00.Cliente;
import ejemplo00.aplicacion.impl.ClienteServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;



/**
 * Ejemplo de API RESTful
 * 
 * http://<hostname>:<port>/<context-root>/<REST-config>/<resource-config>

	context-root 		--> (nombre del war por defecto, se puede cambiar agregando archivo conf. )
	REST-config 		--> se establece en web.xml (tambien existe una anotación para poder establecerlo)
	resource-config		--> se establece con la anotación  @Path
 */

@ApplicationScoped
@Path("/clientes")
public class ClienteRESTful {
	
	@Inject
	private ClienteServiceImpl clienteService;

	
	/**
	 * curl -v http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes
	 * @return
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Cliente> obtenerClientes() {
		System.out.println("Retornando todos los clientes");
		return clienteService.obternerClientes();
	}
	

	
	/**
	 * curl -v http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes/2
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Cliente obtenerCliente(@PathParam("id") int id) { //observar la anotación @PathParam
		System.out.println("Invocando obtenerCliente con id:" + id);
		
		return clienteService.obtenerCliente(id);
	}
	
		
	/**
	 * curl  -X "DELETE" http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes/1
	 * 
	 * @param id
	 */
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public void borrarCliente(@PathParam("id") int id) {
		System.out.println("Invocando borrarCliente con id:" + id);
		
		clienteService.borrarCliente(id);
	}
	
	
	
	/**
	 * 
	 * Observar que nada me impide llamar a borrar utilizando GET
	 * 
	 * @param id
	 */
//	@GET
//	@Path("/{id}")
//	@Produces({MediaType.APPLICATION_JSON})
//	public void borrarCliente2(@PathParam("id") int id) {
//		System.out.println("invocando GET borrarCliente con id:" + id);
//		
//		clienteService.borrarCliente(id);
//	}
	
	/**
	 * curl -X POST http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes 
	 * -H "Content-Type: application/json" 
	 * -d '{"id":3,"nombre":"Marta"}'
	 * 
	 * Observar como la información enviada en el body del mensaje se parsea automáticamente a un 
	 * objeto Cliente.
	 * 
	 * Para que esto suceda, con el mínimo de código posible se tienen que cumplir algunas condiciones, 
	 * por ejemplo:
	 * 		el nombre de los campos del json tiene que coincidir con el nombre de los atributos de la clase
	 * 		la clase tiene que tener un constuctor por defecto
	 * 		la clase tiene que tener los getter y setters para acceder a los atributos
	 * 
	 * @param cli
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //tenemos que indicar como viene formateada la información
	@Produces({MediaType.APPLICATION_JSON})
	public void insertarCliente(Cliente cli) {
		System.out.println("Nuevo cliente:" + cli);
		
		clienteService.insertar(cli);
	}
	
	/**
	 * PUT es una operación indempotente, no importa cuantas veces se ejecuta, sola la primer
	 * cambia el estado del servidor.
	 * 
	 * curl -X PUT http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes/3 
	 * 	-H "Content-Type: application/json" 
	 * 	-d '{"id":3,"nombre":"MARTA"}'
	 * @param cli
	 */
	@PUT 
	@Produces({MediaType.APPLICATION_JSON})
	public void actualizarCliente(Cliente cli) {
		System.out.println("Invocando actualizar cliente: " + cli);
		
		clienteService.actualizarCliente(cli);
	}
	

	
}
