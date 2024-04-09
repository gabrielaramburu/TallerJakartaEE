package ejemplo01;

import ejemplo00.aplicacion.MensajeServiciosImpl;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/mensaje")
@FormAuthenticationMechanismDefinition(
		loginToContinue = 
		@LoginToContinue(
				loginPage = "/credeneciales.hltml", errorPage = "/errorLogin.html"
		))
public class MensajeApi {

	@Inject
	private MensajeServiciosImpl servicios;
	
	@GET
	@Path("/enviarMensaje")
	@RolesAllowed("gerente") //solo los usuarios que pertenezcan a este rol podrán 
	//invocar este método
	@Produces({ MediaType.APPLICATION_JSON })
	
	public String enviarMensajeComoGerente(@QueryParam("mensaje") String mensaje) {
		return servicios.enviarMensajeComoGerente(mensaje);
	}
}