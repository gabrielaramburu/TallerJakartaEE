package org.tallerjava.moduloPeaje.aplicacion.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.tallerjava.moduloPeaje.aplicacion.ServicioPeaje;
import org.tallerjava.moduloPeaje.dominio.Preferencial;
import org.tallerjava.moduloPeaje.dominio.Vehiculo;
import org.tallerjava.moduloPeaje.dominio.repo.PeajeRepositorio;
import org.tallerjava.moduloGestion.interfase.local.ServicioPagoFacade;
import org.tallerjava.moduloPeaje.interfase.evento.out.PublicadorEvento;

@ApplicationScoped
public class ServicioPeajeImpl implements ServicioPeaje {
    private static final Logger log = Logger.getLogger(ServicioPeajeImpl.class);

    @Inject
    private PeajeRepositorio repo;

    @Inject
    private PublicadorEvento evento;

    @Inject
    private ServicioPagoFacade servicioPagoFacade;

    @Override
    public boolean estaHabilitadoSincronico(int tag, String matricula) {
        log.infof("*** Verificando peaje vehiculo: tag %s, matricula: %s", tag, matricula);
        boolean habilitado = false;
        Vehiculo vehiculo = existeVehiculo(tag, matricula);
        if (vehiculo != null) {
            if (vehiculo.nacional()) {
                log.infof("Vehículo nacional: %s",vehiculo.getIdentificador());
                mandarAQueueDePagos(tag, vehiculo);
                habilitado = true;

            } else {
                habilitado = procesarVehiculoExtranjero(tag, vehiculo);
            }
        }

        log.infof("Resultado habilitacion tag %s, matricula %s es: %b", tag, matricula, habilitado);
        return habilitado;
    }

    private boolean  procesarVehiculoExtranjero(int tag, Vehiculo vehiculo) {
        log.infof("*** Procesando pago vehículo extranjero %s ", tag);
        boolean habilitado = false;
        //todos los vehiculos extranjeros son preferenciales
        Preferencial tarifa = repo.obtenerTarifaPreferencial();

        log.infof("Tarifa obtenida %f ",tarifa.getValor());
        //según las reglas del negocio, lo primero es cobrar con PrePago
        habilitado = servicioPagoFacade.realizarPrePago(tag, tarifa.getValor());

        log.infof("Respuesta prePago: %b ",habilitado);
        if (!habilitado) {
            //fallo el cobro prepago, intento con la tarjeta (postPago)
            habilitado = servicioPagoFacade.realizarPostPago(tag, tarifa.getValor());
            log.infof("Respuesta postPago: %b ",habilitado);
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

            evento.publicarPagoSucive("Pago sucive para vehiculo:" + tag);
        }

        return habilitado;
    }

    private void mandarAQueueDePagos(int tag, Vehiculo vehiculo) {
        //TODO por ahor lo procesamos sincrónicamente
        //colocamos un mensaje en la queue
        //el mensaje va a tener la misma información que me llega al autorizar
        //un tag o una matricula o ambas

    }

    private Vehiculo existeVehiculo(int tag, String matricula) {
        Vehiculo vehiculo = repo.findByTag(tag);

        if (vehiculo != null) {
            log.infof("Vehiculo encontrado con tag: %s", tag);
        } else {
            vehiculo = repo.findByMatricula(matricula);
            if (vehiculo != null) {
                log.infof("Vehiculo encontrado com matricula: %s", matricula);
            } else {
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

    @Override
    @Transactional
    public void altaVehiculo(Vehiculo vehiculo) {
        log.infof("Alta de vehiculo %s", vehiculo.toString());
        repo.saveVehiculo(vehiculo);
    }
}
