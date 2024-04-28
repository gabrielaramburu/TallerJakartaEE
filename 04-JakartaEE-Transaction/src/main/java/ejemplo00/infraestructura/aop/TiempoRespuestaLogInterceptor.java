package ejemplo00.infraestructura.aop;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.jboss.logging.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Interceptor
@Priority(1) //para registrar el interceptor y en caso de tener varios definir orden
@MedirTiempos //Este interceptor va a aplicar a los métodos que utilicen esta anotación
public class TiempoRespuestaLogInterceptor{
    private static final Logger log = Logger.getLogger(TiempoRespuestaLogInterceptor.class);

    /**
     * @param invocationContext información que se carga en tiempo de ejecución con el método que se
     *                          está ejecutando
     */
    @AroundInvoke //point cut
    public Object logearTiempos(InvocationContext invocationContext) throws Exception {
        LocalDateTime inicio = LocalDateTime.now();
        log.infof("** Inicio ejecucion: %s", invocationContext.getMethod().getName());
        Object obj = invocationContext.proceed();
        long diff = ChronoUnit.MILLIS.between( inicio, LocalDateTime.now() );
        log.infof("** Fin ejecucion %s, tiempo: %d milis",
                invocationContext.getMethod().getName(), diff);
        return obj;
    }
}
