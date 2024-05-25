package org.tallerjava.moduloGestion.interfase.remota.rest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import org.tallerjava.moduloGestion.aplicacion.ServicioPago;
import org.tallerjava.moduloGestion.dominio.usuario.Usuario;
import org.tallerjava.moduloPeaje.aplicacion.ServicioPeaje;

@ApplicationScoped
@Path("/cliente")
public class ClienteAPI {
    private static final Logger log = Logger.getLogger(ClienteAPI.class);

    @Inject
    private ServicioPago servicioPago;

    //curl -X POST -v http://localhost:8080/06-JakartaProyectoReferencia/trafico/cliente -H "Content-Type: application/json" -d '{"nombre":"nom1","email":"nom1@gmail.com", "nacionalidad":1}'
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long altaCliente(ClienteDTO clienteDTO) {
        log.infof("Nuevo usuario: %s", clienteDTO);

        Usuario usr = clienteDTO.buildUsuario();
        return servicioPago.altaClienteTelepeaje(usr);
    };

    //curl -X POST -v http://localhost:8080/06-JakartaProyectoReferencia/trafico/cliente/saldo -H "Content-Type: application/json" -d '{"idCliente":1,"importe":1000}'
    @POST
    @Path("/saldo")
    public double cargarSaldo(SaldoDTO saldoDTO) {
        log.infof("Carga saldo cliente %s : ", saldoDTO);
        double nuevoSaldo = servicioPago.cargarSaldo(saldoDTO.getIdCliente(), saldoDTO.getImporte());
        return nuevoSaldo;
    }


}
