package org.tallerjava.moduloPeaje.dominio;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //hay otras dos estrategias para el mapeo pero esta me pareció
//la mas simple para este caso
@Table(name =   "peaje_tarifa")
public abstract class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected LocalDateTime fechaAplicacion;   //solo para hacer más interesante el comportamiento de las tarifas
    protected double valor;
}
