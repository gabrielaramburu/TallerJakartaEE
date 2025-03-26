package org.example.modulogestioncliente.interfaces.evento.out;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Este evento se lanza cada vez que se registra un nuevo auto
 */
@AllArgsConstructor
@Getter
public class EventoInformarNuevoVinculo {
    private String matricula;
    private String cedulaCliente;
}
