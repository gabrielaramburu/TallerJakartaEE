package ejemplo00.dominio;

import lombok.Data;
import org.jboss.logging.Logger;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Pago {
    private int id;
    private String descripcion;
    private double monto;
    private Cliente cliente;

    private static final Logger log = Logger.getLogger(Pago.class);

    public int pagar() {
        //aquí va la lógica de negocio realcionada al pago

        //no usar en prod, solo una forma rápida de generar un numero
        // más o menos correlativo
        int idPago = Long.valueOf(Instant.now().toEpochMilli()).intValue() /1000;
        log.info("Realizo pago con id: " + idPago);
        return idPago;
    }
}
