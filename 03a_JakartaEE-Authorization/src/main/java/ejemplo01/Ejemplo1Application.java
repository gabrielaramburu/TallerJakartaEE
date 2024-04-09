package ejemplo01;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.ApplicationPath;

/**
 * Clase que define la configuración de la aplicación.
 * Es una alternativa a utilizar el archivo web.xml (si bien es posible usar los dos)
 */
@ApplicationPath("mensajes")
public class Ejemplo1Application extends Application {
    
}
