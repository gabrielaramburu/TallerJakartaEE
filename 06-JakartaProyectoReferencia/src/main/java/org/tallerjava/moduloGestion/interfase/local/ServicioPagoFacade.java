package org.tallerjava.moduloGestion.interfase.api.local;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.tallerjava.moduloGestion.aplicacion.ServicioPago;
import org.tallerjava.moduloGestion.aplicacion.impl.CapaAplicacionPeajeQualifier;
import org.tallerjava.moduloGestion.dominio.Cuenta;

import java.util.List;

/**
 * Si bien esta fachada es un pasamano, notese que su utilidad esta relacionada
 * a mantener claridad conceptual (un modulo solo se comunica con otro a traves de su
 * capa de interface (o eventos)
 *
 * Si no queremos ser tan puristas, podemos omitir este nivel de abstracción y acceder
 * desde el modulo cliente directamente a la capa de aplicación.
 */
@ApplicationScoped
public class ServicioPagoFacade {

    @Inject
    private ServicioPago servicioPago;

    public boolean realizarPrePago(int tag, double importe) {
        return servicioPago.realizarPrePago(tag, importe);
    }

    public boolean realizarPostPago(int tag, double importe) {
        return servicioPago.realizarPostPago(tag, importe);
    }

    public boolean esClienteTelepeaje(int tag) {
        return servicioPago.esClienteTelepeaje(tag);
    }
}
