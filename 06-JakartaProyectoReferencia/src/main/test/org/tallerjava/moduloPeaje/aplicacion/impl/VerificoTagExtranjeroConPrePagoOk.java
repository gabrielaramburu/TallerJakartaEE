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
import org.tallerjava.moduloGestion.interfase.api.local.ServicioPagoFacade;
import org.tallerjava.moduloPeaje.dominio.*;
import org.tallerjava.moduloPeaje.dominio.repo.PeajeRepositorio;
import org.tallerjava.moduloPeaje.infraestructura.persistencia.PeajeRepositorioImpl;
import org.tallerjava.moduloPeaje.interfase.evento.out.PublicadorEvento;

@EnableWeld
class VerificoTagExtranjeroConPrePagoOk {

    /**
     * Como funcionan los test de la capa de aplicación.
     * Cada implementación (en este caso ServicioPeajeImpl) tiene sus dependencias
     * las cuales son injectadas por el contender (ejemplo: repositorio, serviciosPagodFacade, publicadorEventos)
     *
     * El objetivo de cada test es probar el código del caso de uso, no el código de sus dependencias, por lo tanto,
     * cuando ejecuto los test tengo que brindar objetos mock (fakes) que devuelvan lo que yo quiero.
     *
     * Lo primero es configurar Weld para que use dichos objetos fakes.
     *
     * NOTA: hacer test lleva tiempo, probar todos los casos es deseable en un proyecto real
     * pero es una activad que consume muchos recursos, por lo que en este instancia, solo haremos los principales
     *
     */
    @WeldSetup
    public WeldInitiator weld =
            WeldInitiator.from(ServicioPeajeImpl.class)
                    .addBeans(crearMockRepositorioImpl())
                    .addBeans(crearMockServiciosPagosFacade())
                    .addBeans(crearMockPublicadorEvento())
                    .build();


    /**
     * Esta es la manera en que el framework de dependencias y junit necesita que construyamos los
     * mock para cada dependencia
     * @return
     */
    private Bean<?> crearMockRepositorioImpl() {
        return MockBean.builder()
                .types(PeajeRepositorio.class) //esto lo saco del @inject de ServicioPeajeImpl
                .scope(ApplicationScoped.class)
                .creating(crearRepoImpl())  //aca construyo la implementación que será usasa en este test
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


    /**
     * Aca construyo un implementación "fake" del repositorio que me devuelve un datos concreto
     * relevante para ejecutar este test
     * @return
     */
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

    /**
     * Implementación "fake" del servicio de pagos, solo implemento este metodo porque es lo
     * unico que preciso para probar este caso de pruebas.
     * @return
     *
     */
    private ServicioPagoFacade crearServicioPagoFacade() {
        return new ServicioPagoFacade() {
            public boolean realizarPrePago(int tag, double importe) {
                //Estoy provando que el pago es aceptdo, por eso retorno true.
                //Eventualmente debería de crear otro test para probar los casos donde se devuelve false
                return true;
            }
        };
    }

    @Test
    @DisplayName("Verifico tag de v. extranjero con PrePago confirmado ok")
    void estaHabilitadoAutoExtranjeroConTagPrePagoOk(ServicioPeajeImpl servicioPeaje) {
        Assertions.assertTrue(
                //obervese que los valores pasados como parámetros tiene poca relevancia
                //en este test, ya que el vehiculo recuperado desde el fake de repositorio
                //(implementado arriba) siempre devolverá un vehiculo con tag hardcoded.
                servicioPeaje.estaHabilitadoSincronico(10001,"BAA 1111"));
    }
}
