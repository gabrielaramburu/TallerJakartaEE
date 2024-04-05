package api;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Tag(name="Esta página describe la API del servicio creado")
@ApplicationScoped
@Path("/mensajes")
public class MensajeriaAPI {

	@Inject
	private Buzon buzon;
	
	//curl -X POST http://localhost:8080/02_jakartaRESTful_swagger/api/mensajes -H "Content-Type: application/json" -d '{"fecha":"2024-03-31T13:26:13.534Z[UTC]","mensaje":"hola"}'
	@POST 
	@Produces (MediaType.APPLICATION_JSON)
	public void enviarMensaje(String mensaje, Date fecha) {
		System.out.println("Mensaje agregado ");
		buzon.agregar(mensaje);
	}
	
	
	@GET 
	@Produces (MediaType.APPLICATION_JSON)
	public List<Mensaje> listar() {
		System.out.println("Mensajes devueltos ");
		return buzon.listar();
	}
	
}
