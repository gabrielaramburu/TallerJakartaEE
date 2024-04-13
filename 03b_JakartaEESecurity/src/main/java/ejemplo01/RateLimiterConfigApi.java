package ejemplo01;

import ejemplo00.infraestructura.RateLimiter;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/config")
@DenyAll
public class RateLimiterConfigApi {
	@Inject
	private RateLimiter rateLimiter;
	
	@GET
	@Path("/activarRateLimiter") 
	@Produces({ MediaType.APPLICATION_JSON })
	@RolesAllowed("admin")
	public void activarRateLimiter(@QueryParam("valor") boolean nuevoEstado) {
		rateLimiter.activarRateLimiter(nuevoEstado);
	}
}
