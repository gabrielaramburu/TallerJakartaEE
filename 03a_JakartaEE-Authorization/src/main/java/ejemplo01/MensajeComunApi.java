package ejemplo01;

import ejemplo00.aplicacion.MensajeServicios;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Esta es una API REST sin control de seguridad. 
 * Cualquier puede invocar a sus operaciones.
 */
@ApplicationScoped
@Path("/comun")
public class MensajeComunApi {

	@Inject
	private MensajeServicios servicio;
	
	//curl -v http://localhost:8080/03a_JakartaEE-Authorization/mensajes/comun/enviarMensaje?mensaje=HolaMundo
	@GET
	@Path("/enviarMensaje")
	@Produces({ MediaType.APPLICATION_JSON })
	public String enviarMensaje(@QueryParam("mensaje") String mensaje) {
		return servicio.enviarMensaje(mensaje);
	}
	
	

}