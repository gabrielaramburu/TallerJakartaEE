package ejemplo04;

import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

//Convertimos esta clase en un Decorator
//Observar que implementamos la misma interface que la clase que queremos decorar

//Si declaramos la interface como abstract no estamos obligados a implementar todos sus métodos
//solo decoraremos lo que nos interesa.
@Decorator
@Priority(1) //para habilitar el uso del Decorador
public abstract class ServiceDecorator implements ServiciosClientes {

	@Inject
	@Delegate
	//Con esta anotación indicamos al contenedor que este objeto es el objeto que esta 
	//siendo decorado.
	private ServiciosClientes servicioADecorar;
	
	//Método que nos interesa decorar.
	@Override
	public void procesarPagoClientes() throws Exception {
		try {
			System.out.println("Pasando por el decorador");
			//Invoco al objeto original
			servicioADecorar.procesarPagoClientes();
		} catch (Exception e) {
			//pero si falla, intento solucionar el problema
			System.out.println("Se produjo un error al procesar pago, tomando medidas compensatorias");
			//a continuación iría el  código que por ejemplo, corrige datos inconsistentes,etc
		}
		
		

	}

}
