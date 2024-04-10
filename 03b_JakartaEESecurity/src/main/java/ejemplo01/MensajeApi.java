package ejemplo01;

import ejemplo00.aplicacion.MensajeServiciosImpl;
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


//En este ejemplo se está haciendo lo mismo pero si utilizar el web.xml
@Path("/api")
//Por defecto no permito ejecutar nada sin permisos
@DenyAll
@BasicAuthenticationMechanismDefinition(realmName = "ApplicationRealm")
//El contenedor negocia con el cliente el envío de credenciales si las mismas no 
//vienen en el request
//El realm puede ser visto como el alcance o area dentro de la aplicación (recursos)
//donde aplican estas políticas de seguridad. El cliente cuando envía las credenciales
//las envía para un determinado realm. 
@DeclareRoles({"grupo1", "grupo2"})
public class MensajeApi  {

	@Inject
	private MensajeServiciosImpl servicios;
	
	@GET
	@Path("/enviarMensaje")
	@Produces({ MediaType.APPLICATION_JSON })
	@RolesAllowed("grupo1")
	public String enviarMensajeTipoA(@QueryParam("valor") String mensaje) {
		return servicios.enviarMensajeComoGerente(mensaje);
	}
	
	@GET
	@Path("/enviarMensaje2") 
	@Produces({ MediaType.APPLICATION_JSON })
	@RolesAllowed("grupo2")
	public String enviarMensajeTipoB(@QueryParam("valor") String mensaje) {
		return servicios.enviarMensajeComoGerente(mensaje);
	}
}