package org.tallerjava.moduloMonitoreo.infraestructura;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.influx.InfluxConfig;
import io.micrometer.influx.InfluxMeterRegistry;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.time.Duration;

@ApplicationScoped
public class RegistradorDeMetricas {
    public static final String PEAJE_COUNTER_VEHICULO_NO_ENCONTRADO ="peajeVehiculoNoEncontrado";
    public static final String PEAJE_COUNTER_PAGO_SUCIVE ="peajePagoSucive";
    public static final String GESTION_COUNTER_PRE_PAGO ="gestionPrePago";
    public static final String GESTION_COUNTER_POST_PAGO ="gestionPostPago";


    private InfluxConfig config;

    @PostConstruct
    public void init() {
        //configuración del repositorio de metricas (influxdb)
        config = new InfluxConfig() {
            @Override
            public String get(String s) {
                return null;
            }

            @Override
            public Duration step() {
                return Duration.ofSeconds(10);
            }

            @Override
            public String db() {
                return "metricasTallerJava";
            }
        };


    }

    public void incrementarCounter(String nombreCounter) {
        MeterRegistry meterRegistry;
        meterRegistry = new InfluxMeterRegistry(config, Clock.SYSTEM);
        meterRegistry.counter(nombreCounter).increment();
    }
}
