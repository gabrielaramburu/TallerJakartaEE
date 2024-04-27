package ejemplo00.infraestructura.messaging;

import ejemplo00.aplicacion.PagosServicios;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import org.jboss.logging.Logger;


@MessageDriven(
    activationConfig = {
    @ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "jakarta.jms.Queue"),
    @ActivationConfigProperty(
            propertyName = "destinationLookup",
            propertyValue = "java:app/jms/ServicioPagoQueue"),
    @ActivationConfigProperty
            //Establece el número máximo de consumidores que estarán procesando
            //los mensajes
            //Por defecto este valor es 15 pero lo cambio a 1 para facilitar
            //la prueba que muestra su funcionamiento
            (propertyName = "maxSession", propertyValue = "1")
    }
    )
public class NuevoPagoConsumer implements MessageListener {
    private static final Logger log = Logger.getLogger(NuevoPagoConsumer.class);

    @Inject
    private PagosServicios pagosServicios;

    public NuevoPagoConsumer() {};

    /**
     * Este método tiene la lógica que se procesa cuando el servidor recibe
     * un mensaje desde la queue.
     *
     * @param message the message passed to the listener
     */
    @Override
    public void onMessage(Message message) {
        try {

            String body = message.getBody(String.class);
            log.infof("Nuevo pago received: %s, body: %s", message.toString(),
                    body);

            PagoRealizadoMessage pago = PagoRealizadoMessage.buildFromJson(body);
            pagosServicios.realizarPagoSincro(pago);

        } catch (JMSException e) {
            log.errorf("Se produjo un error al consumir el mensaej Pago %s",e.getMessage());
        }
    }
}
