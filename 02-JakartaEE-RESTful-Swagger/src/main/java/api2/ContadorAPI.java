package api2;

import api2.aplicacion.ContadorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/contador")
public class ContadorAPI {

	@Inject
	private ContadorService contadorService;
	
	//curl -X POST http://localhost:8080/02_jakartaRESTful_swagger/api/contador
	@POST 
	@Produces (MediaType.APPLICATION_JSON)
	public void incrementa() {
		System.out.println("Incrementando contador");
		int valor = contadorService.incrementar();
		System.out.println("Nuevo valor " + valor);
	}
	
	@PUT 
	@Produces (MediaType.APPLICATION_JSON)
	public void inicializar() {
		System.out.println("Inicializando contador.");
		contadorService.inicializar();
	}
	
	
}
