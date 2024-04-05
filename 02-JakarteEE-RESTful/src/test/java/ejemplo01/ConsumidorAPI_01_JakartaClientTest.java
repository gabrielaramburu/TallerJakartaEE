package ejemplo01;

import java.io.StringReader;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ejemplo00.Cliente;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;


/**
 * Clientes implementados con jakarta.ws.rs.client.
 * 
 * Para ejecutar estas funcionalidades se agregaron dos dependencias al proyecto
 * 	una implementación de jakarta.ws.rs.client
 * 	y una implementación de jakarta.json.
 * 
 * ver archivo pom
 */
//@Disabled
class ConsumidorAPI_01_JakartaClientTest {

	@Test
	@DisplayName("Ejemplo básico de client http ")
	void obtenerClientes() {
		Client cliente = ClientBuilder.newClient(); 
		
		String respuesta = cliente
			.target("http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes")
			.request(MediaType.APPLICATION_JSON)
			.get(String.class);
		
		System.out.println(respuesta);
		
	}
	
	@Test
	@DisplayName("Pasando parámetros http, invocando API con estilo rpc ")
	void pasajeParametrosHttp() {
		
		Client cliente = ClientBuilder.newClient(); 
		
		String respuesta = cliente
			.target("http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes")
			.path("getCliente")
			.queryParam("id", "1")
			.request(MediaType.APPLICATION_JSON)
			.get(String.class);
		
		System.out.println(respuesta);
		
	}
	
	
	@Test
	@DisplayName("Parseando respuesta ")
	void parseoDeRespuesta() {
		
		Client httpClient = ClientBuilder.newClient(); 
		
		String respuesta = httpClient
			.target("http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes")
			.path("getCliente")
			.queryParam("id", "2")
			.request(MediaType.APPLICATION_JSON)
			.get(String.class);
		
		JsonReader jsonReader = Json.createReader(new StringReader(respuesta));
		JsonObject objeto = jsonReader.readObject();
		Cliente cliente = new Cliente(
				objeto.getInt("id"),
				objeto.getString("nombre"));
		
				
		System.out.println(cliente.toString());
		
	}

}
