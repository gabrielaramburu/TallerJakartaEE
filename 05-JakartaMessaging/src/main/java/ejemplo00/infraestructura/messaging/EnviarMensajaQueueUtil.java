package ejemplo00.infraestructura.messaging;

import ejemplo00.aplicacion.PagosServiciosImpl;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Queue;
import org.jboss.logging.Logger;

/**
 * Esta clase tiene la responsabilidad de enviar mensajes utilizando la queue de prueba.
 * Voy a utilizar la misma siempre que quiera enviar un mensaje.
 * De esta manera encapsulo el comportamiento.
 */
@ApplicationScoped
public class EnviarMensajaQueueUtil {
    Logger log = Logger.getLogger(PagosServiciosImpl.class);

    //injecto objeto que me permite interactuar con una queue
    @Inject
    private JMSContext jmsContext;

    @Resource (lookup = "java:jboss/exported/jms/queue/servicioPago") //direccion jndi
    //otro tipo de injección de depenencia
    //en este caso injecto un recurso (queue) disponible
    //el parámetro del lookup es el mismo que utilizo para crear en la queue en el script de configuración
    private Queue queuePagosRealizados ;

    public void enviarMensaje(String mensaje) {
        log.infof("Inicio envio mensaje: %s", mensaje);

        jmsContext.createProducer().send(queuePagosRealizados, mensaje);
        log.infof("Fin envio mensaje: %s", mensaje);
    }
}
