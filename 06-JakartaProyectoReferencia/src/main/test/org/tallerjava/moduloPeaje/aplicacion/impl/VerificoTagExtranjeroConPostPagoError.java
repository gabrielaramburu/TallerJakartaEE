package org.tallerjava.moduloPeaje.aplicacion.impl;

import org.jboss.weld.junit5.EnableWeld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tallerjava.moduloGestion.interfase.local.ServicioPagoFacade;

/**
 * Observese que puedo extender test unitarios para poder reutilizar código
 * En este caso el test es igual al extendido con la diferencia de que implemento
 * que postPago de Error.
 */
@EnableWeld
class VerificoTagExtranjeroConPostPagoError extends VerificoTagExtranjeroConPostPagoOk{


    @Override
    public ServicioPagoFacade crearServicioPagoFacade() {
        return new ServicioPagoFacade() {
            @Override
            public boolean realizarPrePago(int tag, double importe) {
                //retorno false para que se ejecute el post Pago
                return false;
            }

            @Override
            public boolean realizarPostPago(int tag, double importe) {
                return false;
            }
        };
    }

    @Test
    @DisplayName("Verifico tag extranjero con PostPago Error")
    @Override
    void testear(ServicioPeajeImpl servicioPeaje) {
        Assertions.assertFalse(
                servicioPeaje.estaHabilitadoSincronico(10001,"BAA 1111"));
    }
}
