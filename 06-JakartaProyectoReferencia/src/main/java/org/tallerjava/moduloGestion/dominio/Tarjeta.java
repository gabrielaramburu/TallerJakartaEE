package org.tallerjava.moduloGestion.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Tarjeta {
    private long id;
    private int nro;
    private LocalDateTime fechaVto;
    private String nombreCompletoUsuario;
}
