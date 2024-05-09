package org.tallerjava.moduloPeaje.aplicacion.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.tallerjava.moduloGestion.dominio.Cuenta;
import org.tallerjava.moduloGestion.dominio.PostPaga;
import org.tallerjava.moduloGestion.dominio.PrePaga;
import org.tallerjava.moduloPeaje.aplicacion.ServicioPeaje;
import org.tallerjava.moduloPeaje.dominio.Preferencial;
import org.tallerjava.moduloPeaje.dominio.Vehiculo;
import org.tallerjava.moduloPeaje.dominio.repo.PeajeRepositorio;
import org.tallerjava.moduloGestion.interfase.api.local.ServicioPagoFacade;
import org.tallerjava.moduloPeaje.interfase.evento.out.PublicadorEvento;

import java.util.List;

@ApplicationScoped
public class ServicioPeajeImpl implements ServicioPeaje {
    @Inject
    private PeajeRepositorio repo;

    @Inject
    private PublicadorEvento evento;

    @Inject
    private ServicioPagoFacade servicioPagoFacade;

    @Override
    public boolean estaHabilitadoSincronico(int tag, String matricula) {
        boolean habilitado = false;
        Vehiculo vehiculo = existeVehiculo(tag, matricula);
        if (vehiculo != null) {
            if (vehiculo.nacional()) {
                mandarAQueueDePagos(vehiculo);
                habilitado = true;

            } else {
                habilitado = procesarVehiculoExtranjero(tag, vehiculo);
            }
        }


        return habilitado;
    }

    private boolean  procesarVehiculoExtranjero(int tag, Vehiculo vehiculo) {
        boolean habilitado = false;
        //todos los vehiculos extranjeros son preferenciales
        Preferencial tarifa = repo.obtenerTarifaPreferencial();

        //según las reglas del negocio, lo primero es cobrar con PrePago
        habilitado = servicioPagoFacade.realizarPrePago(tag, tarifa.getValor());
        if (!habilitado) {
            //fallo el cobro prepago, intento con la tarjeta (postPago)
            habilitado = servicioPagoFacade.realizarPrePago(tag, tarifa.getValor());
            if (!habilitado) {
                //TODO mando evento al modulo de monitoreo
                //el auto no pasa
            }
        }
        return habilitado;
    }


    private boolean  procesarVehiculoNacional(int tag, Vehiculo vehiculo) {
        boolean habilitado = false;

        Preferencial tarifa = repo.obtenerTarifaPreferencial();
        if (servicioPagoFacade.esClienteTelepeaje(tag)) {
            //según las reglas del negocio, lo primero es cobrar con PrePago
            habilitado = servicioPagoFacade.realizarPrePago(tag, tarifa.getValor());
            if (!habilitado) {
                //fallo el cobro prepago, intento con la tarjeta (postPago)
                habilitado = servicioPagoFacade.realizarPrePago(tag, tarifa.getValor());
            }
        }
        if (!habilitado) {
            //significa que no es cliente preferencial o que fallaron los dos sistemas
            //de cobro previos
            //TODO invocar a modulo de pago Sucive
        }

        return habilitado;
    }

    private void mandarAQueueDePagos(Vehiculo vehiculo) {
        //TODO esto lo vamos a hacer más adelante.
    }

    private Vehiculo existeVehiculo(int tag, String matricula) {
        Vehiculo vehiculo = repo.findByTag(tag);
        if (vehiculo == null) {
            vehiculo = repo.findByMatricula(matricula);
            if (vehiculo == null) {
                //error grave el vehiculo no esta en el sistema
                evento.publicarVehiculoNoEncontrado(
                        "Vehiculo no encontrado: " + tag + " " + matricula);
            }
        }
        return vehiculo;
    }

    @Override
    public void actualizarTarifaComun(double importe) {

    }

    @Override
    public void actualizarTarifaPreferencial(double importe) {

    }
}
