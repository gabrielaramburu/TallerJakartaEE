package ejemplo01;


import ejemplo00.aplicacion.MensajeServiciosImpl;
import ejemplo00.infraestructura.ratelimiter.RateLimiter;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;



//Por defecto no permito ejecutar nada sin permisos. 
//Buena práctica
@DenyAll
@Path("/api")
public class MensajeApi  {

	@Inject
	private MensajeServiciosImpl servicios;
	
	
	//curl --user usr1:usr1pass -v http://localhost:8080/03b_JakartaEESecurity/seguro/api/enviarMensaje?valor=Hola
	@GET
	@Path("/enviarMensaje")
	@Produces({ MediaType.APPLICATION_JSON })
	@RolesAllowed("grupo1")
	public String enviarMensajeTipoA(@QueryParam("valor") String mensaje) {
		return servicios.enviarMensajeComoGerente(mensaje);
	}
	
	//curl --user usr2:usr2pass -v http://localhost:8080/03b_JakartaEESecurity/seguro/api/enviarMensaje2?valor=Hola2
	@GET
	@Path("/enviarMensaje2") 
	@Produces({ MediaType.APPLICATION_JSON })
	@RolesAllowed("grupo2")
	public String enviarMensajeTipoB(@QueryParam("valor") String mensaje) {
		return servicios.enviarMensajeComoGerente(mensaje);
	}
	
	
}