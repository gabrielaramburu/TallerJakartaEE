package ejemplo01;

import ejemplo00.aplicacion.MensajeServicios;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Esta es una API REST con control de seguridad básico.
 * Tener en cuenta que la configuración de seguridad se establece 
 * (al menos en este ejemplo) en el archivo src/main/webapp/WEB-INF/web.xml)
 * 
 * Tenga en cuenta que además los rol/usuario y 
 * sus credendiales tiene que estar configuradas en el servidor (seguir instrucciones del readme)
 */
@ApplicationScoped
@Path("/gerente") //observar como la configuración del web.xml hace referencia a este recurso
public class MensajeGerenteApi {

	/*
	 * *
	 */
	@Inject
	private MensajeServicios servicio;
	
	//curl -v http://localhost:8080/03a_JakartaEE-Authorization/mensajes/gerente/enviarMensaje?mensaje=HolaMundo
	//con la url anterior devuelve 401 no autorizado ya que no se envían las credenciales
	
	//curl --user pepe:contrasenia2024 -v http://localhost:8080/03a_JakartaEE-Authorization/mensajes/gerente/enviarMensaje?mensaje=HolaMundo
	//observar que se envían las credenciales
	
	@GET
	@Path("/enviarMensaje")
	//invocar este método
	@Produces({ MediaType.APPLICATION_JSON })
	public String enviarMensajeComoGerente(@QueryParam("mensaje") String mensaje) {
		return servicio.enviarMensajeComoGerente(mensaje);
	}
	
	
	//curl --cacert certificadoPrueba.pem --user pepe:contrasenia2024 -v https://localhost:8443/03a_JakartaEE-Authorization/mensajes/gerente/enviarMensajeSeguro?mensaje=HolaMundo
	//Nota1 :observar como se incluye el certificado .pem para poder conectarse con ssl
	//Este archivo contiene la llave pública del servidor
	//Nota 2:notar que el puerto de comunicación es 8443
	//Nota 3:los certificados del servidor (.pem) los obtuvimos con la herramienta openssl
	
	//openssl s_client -showcerts -connect localhost:8443 </dev/null | sed -n -e '/-.BEGIN/,/-.END/ p' > certificadoPrueba.pem
	//genera archivo pen con los certificados del servidor
	
	//Nota 4: notar que no el curl busca el certificado desde el lugar donde se ejecuta, (no puedo
	//ejecutar el curl desde cualquier lado)
	@GET
	@Path("/enviarMensajeSeguro")
	//invocar este método
	@Produces({ MediaType.APPLICATION_JSON })
	public String enviarMensajeSeguro(@QueryParam("mensaje") String mensaje) {
		System.out.println("Procesando request del lado del servidor.");
		return servicio.enviarMensajeComoGerente(mensaje);
	}
	
	

}