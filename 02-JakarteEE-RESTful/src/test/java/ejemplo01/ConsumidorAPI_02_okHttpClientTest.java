package ejemplo01;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//@Disabled
public class ConsumidorAPI_02_okHttpClientTest {

	@Test
	@DisplayName("Insertar clientes con OkHttpClient")
	public void insertarCliente() {
		OkHttpClient cliente = new OkHttpClient();
		
		String json = "{\"id\":5,\"nombre\":\"Alberto\"}";
		RequestBody body = 
				RequestBody.create(json, MediaType.get("application/json"));
		
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes")
				.post(body)
				.build();
		
		try {
			Response response = cliente.newCall(request).execute();
			System.out.println(
					response.body().string());
			
			assertThat(response.code() == 200);
			
		} catch (IOException e) {
			System.out.println("Se produjo una exception");
		}
		
	}
	
	@Test
	@DisplayName("Obtener clientes con  OkHttpClient")
	public void obtenerClientes() {
		OkHttpClient cliente = new OkHttpClient();
		
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/02_jakartaRESTful_ejemplo/api/clientes")
				.build();
		
		try {
			Response response = cliente.newCall(request).execute();
			System.out.println(
					response.body().string());
			
			
			assertThat(response.code() == 200);
			
		} catch (IOException e) {
			System.out.println("Se produjo una exception");
		}
		
	}
}
