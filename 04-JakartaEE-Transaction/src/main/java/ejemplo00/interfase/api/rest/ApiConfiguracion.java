package ejemplo00.interfase.api.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped

@ApplicationPath("/api")
public class ApiConfiguracion extends Application {
}
