package ejemplo00.aplicacion;

import ejemplo00.dominio.Cliente;
import ejemplo00.dominio.Pago;
import ejemplo00.infraestructura.messaging.EnviarMensajaQueueUtil;
import ejemplo00.infraestructura.messaging.PagoRealizadoMessage;
import ejemplo00.interfase.api.PagoDTO;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;
import org.jboss.logging.Logger;

@ApplicationScoped
public class PagosServiciosImpl implements PagosServicios {
    Logger log = Logger.getLogger(PagosServiciosImpl.class);

    @Inject
    private EnviarMensajaQueueUtil mensajePago;

    @Override
    public void realizarPagoAsyncro(PagoDTO pago) {
        //Eventualmente podría enviar el pagoDTO como mensaje
        //pero siempre que se pueda, conviene desacoplar conceptos
        //utilizados en diferentes capas
        //Para este caso sencillo no afecta, pero lo quiero dejar asentado
        //como una buena práctica
        PagoRealizadoMessage pagoMessage = new PagoRealizadoMessage(
                pago.descripcion(),
                pago.monto(),
                pago.idCliente()
        );
        //en el mensaje envío una representacion json del objeto
        // que representa el mensaje
        String representacionJson = pagoMessage.toJson();
        log.infof("Convierto DTO a json: %s",representacionJson);
        mensajePago.enviarMensaje(representacionJson);

    }




    @Override
    public void realizarPagoSincro(PagoRealizadoMessage pagoMessage) {
        //Aquí podría ir a buscar el cliente a la BD
        Cliente cliente = new Cliente(pagoMessage.idCliente());

        Pago pagoNuevo = new Pago();
        pagoNuevo.setCliente(cliente);
        pagoNuevo.setDescripcion(pagoMessage.descripcion());
        pagoNuevo.setMonto(pagoMessage.monto());
        pagoNuevo.pagar();

        pausa();

        //aqui podría ir a la base a guardar el pago
    }

    private void pausa() {
        //simula algo de trabajo
        try {
            log.info("realizando pago...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
