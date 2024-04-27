package ejemplo00.interfase.api;

import ejemplo00.aplicacion.PagosServicios;
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
        log.infof("Fin Pago");
    }
}
