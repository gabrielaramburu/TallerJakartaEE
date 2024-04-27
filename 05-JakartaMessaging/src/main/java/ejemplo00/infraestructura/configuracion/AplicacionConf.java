package ejemplo00.infraestructura.configuracion;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("api")
public class AplicacionConf extends Application {
}
