package org.tallerjava.moduloPeaje.dominio;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Identificador {
    @Column(nullable = false)
    private String matricula;
    @Column(nullable = false)
    private int tag;

    public Identificador() {}
}
