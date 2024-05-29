package org.tallerjava.moduloGestion.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance (strategy = InheritanceType.JOINED) //los campos comunes en una tabla y los campos de cada subclase
// en tablas separadas

//tablas separadas
@Table(name = "gestion_cuenta")
public abstract class Cuenta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;
    protected String descripcion;
    protected LocalDateTime fechaApertura;

}
