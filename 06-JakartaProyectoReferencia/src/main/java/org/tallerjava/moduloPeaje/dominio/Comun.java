package org.tallerjava.moduloPeaje.dominio;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("comun")
public class Comun extends Tarifa{
    public Comun(LocalDateTime fecha, double monto) {
        this.valor = monto;
        this.fechaAplicacion = fecha;
    }
}
