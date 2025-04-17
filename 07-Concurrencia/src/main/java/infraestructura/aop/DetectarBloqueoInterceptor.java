package infraestructura.aop;

import application.concurrente.CuentaConcurrenteServices.ResultadoAcreditacion;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor //este interceptos se invoca cada vez que se ejcute un método que este anotado
//con la anotación @DetectarBloqueoOptimista
@Priority(1) //establezco prioridad del interceptor, tener en cuenta que puede haber más de uno
@DetectarBloqueoOptimista
public class DetectarBloqueoInterceptor {

	@AroundInvoke
	public Object detectarBloqueo(InvocationContext invocationContext)  {
		
		try {
			//llamada al método original
			//acá pongo las instrucciones que quiero que se ejecuten antes
			Object obj = invocationContext.proceed();
			//acá pongo las instrucciones que quiero que se ejecuten después
			System.out.println("OK, se actualizó el saldo correctamente.");
			return obj;
		}catch (Exception e) {
			//en este ejemplo creo el Interceptor solo para capturar
			//la exception que se lanza por el bloqueo optimista
			System.out.println("ERROR se produjo un error " + e.getMessage() + e.getCause());
			return ResultadoAcreditacion.ACREDITACION_ERROR;
		} 
	}
}
