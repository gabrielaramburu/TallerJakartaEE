package org.tallerjava.moduloPeaje.dominio;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("preferencial") //identificador del registro
public class Preferencial extends Tarifa{

    public Preferencial(LocalDateTime fecha, double monto) {
        this.valor = monto;
        this.fechaAplicacion = fecha;
    }
}
