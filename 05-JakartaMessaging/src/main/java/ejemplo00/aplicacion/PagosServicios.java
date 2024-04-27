package ejemplo00.aplicacion;

import ejemplo00.infraestructura.messaging.PagoRealizadoMessage;
import ejemplo00.interfase.api.PagoDTO;

public interface PagosServicios {
    public void realizarPagoAsyncro(PagoDTO pagoRealizado);
    public void realizarPagoSincro(PagoRealizadoMessage pagoRealizado);
}
