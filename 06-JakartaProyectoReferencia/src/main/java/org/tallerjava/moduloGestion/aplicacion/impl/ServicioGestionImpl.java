package org.tallerjava.moduloGestion.aplicacion.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.tallerjava.moduloGestion.aplicacion.ServicioGestion;
import org.tallerjava.moduloGestion.dominio.PrePaga;
import org.tallerjava.moduloGestion.dominio.Vehiculo;
import org.tallerjava.moduloGestion.dominio.usuario.ClienteTelepeaje;
import org.tallerjava.moduloGestion.dominio.usuario.Usuario;
import org.tallerjava.moduloGestion.dominio.repo.UsuarioRepositorio;
import org.tallerjava.moduloGestion.interfase.evento.out.PublicadorEventoGestion;

import java.time.LocalDateTime;

@ApplicationScoped
public class ServicioGestionImpl implements ServicioGestion {
    private static final Logger log = Logger.getLogger(ServicioGestionImpl.class);

    @Inject
    private UsuarioRepositorio repoUsuario;

    @Inject
    private PublicadorEventoGestion evento;

    @Override
    public boolean realizarPrePago(int tag, double importe) {
        boolean realizado = false;
        Vehiculo vehiculo = repoUsuario.findByTag(tag);
        if (vehiculo != null) {

            if ( vehiculo.getCliente() != null) {
                ClienteTelepeaje cli = vehiculo.getCliente();
                PrePaga ctaPrepaga = cli.getCtaPrepaga();

                if (ctaPrepaga.getSaldo() >= importe) {
                    //TODO controllar que el salo sea suficente
                    ctaPrepaga.descontarSaldo(importe);

                    notificarPrePago(cli);
                    realizado = true;

                } else {
                    log.infof("Saldo insuficiente %s", tag);
                    realizado = false;
                }

            } else {
                //estoy frente a otro problema de inconsistencia ya que para tener un tag
                //tengo que ser cliente del telepeaje
                //TODO logear y mandar evento al modulo de monitoreo
            }

        } else {
            //estamos frente a un problema grave ya que dado un tag (vehiculo),
            // no podemos saber a que Cliente pertenece, recordar que los tags se
            //entregan cuando el Cliente se registra en el sistema
            //TODO logear y mandar evento al modulo de monitorio
            log.infof("Error grave: No existe el usuario con el tag %d", tag);
        }
        return realizado;
    }

    private void notificarPrePago(ClienteTelepeaje usr) {
        evento.publicarPagoCuentaPrePaga("PrePago realizado"+usr.getIdClienteTelepeaje());
    }

    @Override
    public boolean realizarPostPago(int tag, double importe) {
        //TODO muy parecido al anterior con la diferencia de que voy a tener que
        //interactuar con el modulo de Medios de pagos para cobrar con tarjeta

        evento.publicarPagoCuentaPostPaga("PostPago realizado"+tag);
        return true;
    }

    @Override
    public boolean esClienteTelepeaje(int tag) {
        Vehiculo vehiculo = repoUsuario.findByTag(tag);

        if (vehiculo.getCliente() != null) {
            return true;
        } else return false;
    }

    @Override
    @Transactional
    public long altaClienteTelepeaje(Usuario usuario) {
        PrePaga prePaga = new PrePaga(0, LocalDateTime.now());

        //los clientes nuevos no tienen porque tener tarjetas asociadas
        ClienteTelepeaje clienteTelepeaje = new ClienteTelepeaje(prePaga,null);
        usuario.setClienteTelepeaje(clienteTelepeaje);
        return repoUsuario.save(usuario);
    }

    @Override
    @Transactional
    public double cargarSaldo(long idUsuario, double importe) {
        Usuario usr = repoUsuario.findById(idUsuario);
        if (usr != null) {
            double saldo = usr.getClienteTelepeaje().getCtaPrepaga().getSaldo();
            log.infof("Saldo actual usuario %s es %s", usr.getNombre() , saldo);
            usr.cargarSaldo(importe);
            repoUsuario.actualizarUsuario(usr);
        }
        return usr.consultarSaldo(); //notese que el manejo de errores es deficiente
    }

    @Override
    @Transactional
    public boolean vincularVehiculo(Vehiculo vehiculo, long idCliente) {
        Usuario usr = repoUsuario.findById(idCliente);
        if (usr != null) {
            vehiculo.setCliente(usr.getClienteTelepeaje());
            repoUsuario.vincularVehiculo(vehiculo);
            log.infof("Se vinculo vehiculo %s", vehiculo.toString());
            evento.publicarNuevoVehiculo(vehiculo);
        } else {
            log.debugf("No se encuentra el cliente con id %s",idCliente);
            //manejo de errores deficiente
            return false;
        }
        return true;
    }


}
