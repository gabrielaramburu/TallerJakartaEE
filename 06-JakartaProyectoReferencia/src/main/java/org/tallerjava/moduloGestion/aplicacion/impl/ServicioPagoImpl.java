package org.tallerjava.moduloGestion.aplicacion.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.tallerjava.moduloGestion.aplicacion.ServicioPago;
import org.tallerjava.moduloGestion.dominio.Cuenta;
import org.tallerjava.moduloGestion.dominio.PrePaga;
import org.tallerjava.moduloGestion.dominio.Usuario;
import org.tallerjava.moduloGestion.dominio.repo.UsuarioRepositorio;

import java.util.List;

@ApplicationScoped
public class ServicioPagoImpl implements ServicioPago {
    @Inject
    private UsuarioRepositorio repoUsuario;

    @Override
    public boolean realizarPrePago(int tag, double importe) {
        boolean realizado = false;
        Usuario usr = repoUsuario.findByTag(tag);
        if (usr != null) {
            if (usr.getClienteTelepeaje() != null) {
                PrePaga ctaPrepaga = usr.getClienteTelepeaje().getCtaPrepaga();
                ctaPrepaga.descontarSaldo(importe);

                notificarPrePago(usr);
                realizado = true;
            } else {
                //estoy frente a otro problema de inconsistencia ya que para tener un tag
                //tengo que ser cliente del telepeaje
                //TODO logear y mandar evento al modulo de monitoreo
            }
            realizado = true;
        } else {
            //estamos frente a un problema grave ya que dado un tag (vehiculo),
            // no podemos saber a que Cliente pertenece, recordar que los tags se
            //entregan cuando el Cliente se registra en el sistema
            //TODO logear y mandar evento al modulo de monitorio
        }
        return realizado;
    }

    private void notificarPrePago(Usuario usr) {
        //TODO lanzar evento al modulo de monitoreo indicando prePago ok
    }

    @Override
    public boolean realizarPostPago(int tag, double importe) {
        //TODO muy parecido al anterior con la diferencia de que voy a tener que
        //interactuar con el modulo de Medios de pagos para cobrar con tarjeta
        return false;
    }

    @Override
    public boolean esClienteTelepeaje(int tag) {
        Usuario usuario = repoUsuario.findByTag(tag);
        if (usuario.getClienteTelepeaje() != null) {
            return true;
        } else return false;
    }

}
