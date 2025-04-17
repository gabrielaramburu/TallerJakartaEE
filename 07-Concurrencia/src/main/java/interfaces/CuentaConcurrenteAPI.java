package interfaces;

import application.concurrente.CuentaConcurrenteServices;
import application.concurrente.CuentaConcurrenteServices.ResultadoAcreditacion;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/cuentasC")
public class CuentaConcurrenteAPI {

	@Inject
	private CuentaConcurrenteServices servicios;
	
	//curl -X POST http://localhost:8080/07_Concurrencia/api/cuentasC/100/movimientos
	// -H "Content-Type: application/json" 
	// -d '{"importe":100,"tipoMovimiento":"DEPOSITO", "concepto":"prueba concurrencia"}'
	@POST 
	@Path("/{idCuenta}/movimientos")
	@Consumes(MediaType.APPLICATION_JSON) //tenemos que indicar como viene formateada la información en el body
	@Produces (MediaType.APPLICATION_JSON)
	public Response movimientos(
			@PathParam("idCuenta") int idCuenta,
			DTOMovimiento movimiento) {
		
		System.out.println("### Nuevo movimiento: " + movimiento.toString());
		
		ResultadoAcreditacion resultado =
				servicios.acreditarConcurrente(idCuenta, movimiento.importe);
		
		if (resultado == ResultadoAcreditacion.ACREDITACION_ERROR) {
			return Response
				      .status(Response.Status.INTERNAL_SERVER_ERROR)
				      .entity("No se proceso transaccion")
				      .build();
		} else {
			return Response
				      .status(Response.Status.OK)
				      .entity("Transaccion procesada correctamente.")
				      .build();
		}
	}
	
	//curl -X GET http://localhost:8080/07_Concurrencia/api/cuentasC/100/movimientos/saldo
	
	//for i in {1..10}; do curl -X GET http://localhost:8080/07_Concurrencia/api/cuentasC/100/movimientos/saldo ; done
	@GET
	@Path("/{idCuenta}/movimientos/saldo")
	@Produces (MediaType.APPLICATION_JSON)
	public int consultarSaldo(@PathParam("idCuenta") int idCuenta) {
		System.out.println("### Consulta saldo para cuenta: " + idCuenta);
		return servicios.consultarSaldo(idCuenta);
	}
	
	//curl -X POST http://localhost:8080/07_Concurrencia/api/cuentasC/100/inicializar
	@POST
	@Path("/{idCuenta}/inicializar")
	@Produces (MediaType.APPLICATION_JSON)
	public void inicializar(@PathParam("idCuenta") int idCuenta) {
		System.out.println("### Inicializo cuenta " + idCuenta);
		servicios.inicializar(idCuenta);
	}
}
