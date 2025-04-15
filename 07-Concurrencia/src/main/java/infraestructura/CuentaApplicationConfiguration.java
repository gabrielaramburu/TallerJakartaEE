package infraestructura;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Una alternativa a tener el archivo de configuración WEB-INF/web.xml 
 */
@ApplicationPath("/api")
public class CuentaApplicationConfiguration extends Application{

}

