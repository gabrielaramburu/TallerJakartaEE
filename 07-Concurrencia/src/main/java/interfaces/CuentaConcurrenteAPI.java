package interfaces;

import application.concurrente.CuentaConcurrenteServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
	public void movimientos(
			@PathParam("idCuenta") int idCuenta,
			DTOMovimiento movimiento) {
		
		System.out.println("### Nuevo movimiento: " + movimiento.toString());
		
		servicios.acreditarConcurrente(idCuenta, movimiento.importe);
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
