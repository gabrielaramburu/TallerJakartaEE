package org.tallerjava.moduloGestion.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

public abstract class Cuenta {
    protected long id;
    protected long nroCuenta;
    protected LocalDateTime fechaApertura;

}
