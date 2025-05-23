package ejemplo01;

import ejemplo00.infraestructura.ratelimiter.RateLimiter;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/config")
@DenyAll
public class RateLimiterConfigApi {
	@Inject
	private RateLimiter rateLimiter;
	
	//curl --user usr4:usr4pass -v http://localhost:8080/03b_JakartaEESecurity/seguro/config/activarRateLimiter?valor=tru
		
	@GET
	@Path("/activarRateLimiter") 
	@Produces({ MediaType.APPLICATION_JSON })
	@RolesAllowed("admin") //solamente los administradores pueden prender/apagar el ratelimiter
	public Response activarRateLimiter(@QueryParam("valor") boolean nuevoEstado) {
		rateLimiter.activarRateLimiter(nuevoEstado);
		return Response
			      .status(Response.Status.OK)
			      .entity("El estado del RateLimiter se cambió correctamente.")
			      .build();
	}
}
