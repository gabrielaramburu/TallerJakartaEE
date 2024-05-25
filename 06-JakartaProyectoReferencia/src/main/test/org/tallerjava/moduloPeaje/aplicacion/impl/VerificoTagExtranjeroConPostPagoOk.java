package org.tallerjava.moduloPeaje.aplicacion.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.Bean;
import org.jboss.weld.junit.MockBean;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tallerjava.moduloGestion.interfase.local.ServicioPagoFacade;
import org.tallerjava.moduloPeaje.dominio.*;
import org.tallerjava.moduloPeaje.dominio.repo.PeajeRepositorio;
import org.tallerjava.moduloPeaje.infraestructura.persistencia.PeajeRepositorioImpl;
import org.tallerjava.moduloPeaje.interfase.evento.out.PublicadorEvento;

@EnableWeld
class VerificoTagExtranjeroConPostPagoOk {

    @WeldSetup
    public WeldInitiator weld =
            WeldInitiator.from(ServicioPeajeImpl.class)
                    .addBeans(crearMockRepositorioImpl())
                    .addBeans(crearMockServiciosPagosFacade())
                    .addBeans(crearMockPublicadorEvento())
                    .build();


    private Bean<?> crearMockRepositorioImpl() {
        return MockBean.builder()
                .types(PeajeRepositorio.class)
                .scope(ApplicationScoped.class)
                .creating(crearRepoImpl())
                .build();
    }

    private Bean<?> crearMockServiciosPagosFacade() {
        return MockBean.builder()
                .types(ServicioPagoFacade.class)
                .scope(ApplicationScoped.class)
                .creating(
                        crearServicioPagoFacade()
                ).build();
    }

    private Bean<?> crearMockPublicadorEvento() {
        return MockBean.builder()
                .types(PublicadorEvento.class)
                .scope(ApplicationScoped.class)
                .creating(
                        new PublicadorEvento()
                ).build();
    }



    private PeajeRepositorio crearRepoImpl() {
        return new PeajeRepositorioImpl() {

            @Override
            public Vehiculo findByTag(int tag) {
                Vehiculo vehiculo = new Vehiculo(1,
                        new Identificador(1,"BAA 1111", tag),
                        "ford", "fiesta", Nacionalidad.EXTRANJERO);
                return vehiculo;
            }
            @Override
            public Preferencial obtenerTarifaPreferencial() {
                return new Preferencial(180);
            }

            @Override
            public Comun obtenerTarifaComun() {
                return new Comun(180);
            }
        };
    }


    public ServicioPagoFacade crearServicioPagoFacade() {
        return new ServicioPagoFacade() {
            @Override
            public boolean realizarPrePago(int tag, double importe) {
                //retorno false para que se ejecute el post Pago
                return false;
            }

            @Override
            public boolean realizarPostPago(int tag, double importe) {
                return true;
            }
        };
    }

    @Test
    @DisplayName("Verifico tag extranjero con PostPago confirmado ok")
    void testear(ServicioPeajeImpl servicioPeaje) {
        Assertions.assertTrue(
                servicioPeaje.estaHabilitadoSincronico(10001,"BAA 1111"));
    }
}
