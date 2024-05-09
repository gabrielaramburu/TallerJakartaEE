package ejemplo00.interfase.api;

import ejemplo00.aplicacion.PagosServicios;
import ejemplo00.infraestructura.messaging.PagoRealizadoMessage;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.logging.Logger;

@ApplicationScoped

@Path("/pagos")
public class PagoApI {
    Logger log = Logger.getLogger(PagoApI.class);

    @Inject
    private PagosServicios pagos;


    @POST
    public void realizarPago(PagoDTO pagoDTO) {
        log.infof("Inicio Pago");

        pagos.realizarPagoAsyncro(pagoDTO);
        /*PagoRealizadoMessage pagoMessage = new PagoRealizadoMessage(
                pagoDTO.descripcion(),
                pagoDTO.monto(),
                pagoDTO.idCliente()
        );
        pagos.realizarPagoSincro(pagoMessage);
        */

        log.infof("Fin Pago");
    }
}
