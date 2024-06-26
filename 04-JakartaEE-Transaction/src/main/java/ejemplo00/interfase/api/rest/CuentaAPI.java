package ejemplo00.interfase.api.rest;

import ejemplo00.aplicacion.CuentaServicios;
import ejemplo00.dominio.Cliente;
import ejemplo00.dominio.Movimiento;
import ejemplo00.dominio.TipoMovimiento;
import ejemplo00.dominio.exception.SaldoInsuficienteException;
import ejemplo00.infraestructura.aop.MedirTiempos;
import ejemplo00.interfase.api.rest.dto.MovimientoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@ApplicationScoped
@Path("/cuentas")
public class CuentaAPI {
    private static final Logger log = Logger.getLogger(CuentaAPI.class);

    @Inject
    private CuentaServicios cuentaServicios;


    @GET
    @Path("/clientes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listarClientes() {
        log.debug("Listar clientes");
        return cuentaServicios.obtenerClientes();
    }


    @PUT
    @Path("/clientes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void nuevoCliente(Cliente cli) {
        log.debugf("Alta cliente: %s", cli.toString());
        cuentaServicios.insertarCliente(cli);
    }


    @PUT
    @Path("/clientes/{id}/movimientos/debito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @MedirTiempos //con esto digo que el método será incerceptado, declaro un joinpoint
    //puedo además poner la anotación en la clase para que aplique sobre todos los métodos
    public void debitarCuenta(@PathParam("id") int idCliente, MovimientoDTO movDTO)  {
        log.infof("Inicio: debitar cliente %d %s", idCliente, movDTO.toString());
            Movimiento movimiento =
                new Movimiento(
                        LocalDateTime.now(),
                        movDTO.getDesc(),
                        movDTO.getImporte(),
                        TipoMovimiento.DEBITO);


        try {
            cuentaServicios.nuevoMovimiento(idCliente, movimiento);
            log.infof("Fin: debitar cliente %d %s", idCliente, movimiento);
        } catch (SaldoInsuficienteException e) {
            log.errorf("Error inesperado %s", e.getMessage());
            //TODO mandar una alerta al montitor
        }
    }

    @PUT
    @Path("/clientes/{id}/movimientos/credito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void acreditarCuenta(@PathParam("id") int idCliente, MovimientoDTO movDTO) throws SaldoInsuficienteException {
        LocalDateTime inicio = LocalDateTime.now(); //comienza medición

        log.infof("Inicio: acreditar cliente %d %s", idCliente, movDTO.toString());
        Movimiento movimiento =
                new Movimiento(
                        LocalDateTime.now(),
                        movDTO.getDesc(),
                        movDTO.getImporte(),
                        TipoMovimiento.CREDITO);

        log.debugf("Movimiento: %s", movimiento.toString());
        cuentaServicios.nuevoMovimiento(idCliente, movimiento);

        long diff = ChronoUnit.MILLIS.between(inicio, LocalDateTime.now()); //finaliza medición
        log.infof("Fin: acreditar cliente %d, duracion: %d", idCliente, diff);
    }




}
