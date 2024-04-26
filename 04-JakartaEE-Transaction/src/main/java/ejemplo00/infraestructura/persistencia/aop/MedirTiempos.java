package ejemplo00.infraestructura.persistencia.aop;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Creo un Interceptor Binding
 * Es una anotación que voy a utilizar para anotar metodos de mis las clases
 * que quiero interceptar con algún Interceptor
 *
 * Cada vez que use esta anotación estaré definiendo un joinpoint
 */
@InterceptorBinding
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MedirTiempos {
}
