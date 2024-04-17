package ejemplo00.infraestructura.seguridad;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

//En este ejemplo se está haciendo lo mismo pero sin utilizar el web.xml
@BasicAuthenticationMechanismDefinition(realmName = "ApplicationRealm")
//El contenedor negocia con el cliente el envío de credenciales si las mismas no 
//vienen en el request
//El realm puede ser visto como el alcance o area dentro de la aplicación (recursos)
//donde aplican estas políticas de seguridad. El cliente cuando envía las credenciales
//las envía para un determinado realm. 
@DeclareRoles({"grupo1", "grupo2", "admin"})
//grupos que utilizan las apis
@ApplicationScoped
public class SeguridadConfiguracion {

}
