package org.tallerjava.moduloGestion.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tallerjava.moduloGestion.dominio.usuario.ClienteTelepeaje;
import org.tallerjava.moduloGestion.dominio.Nacionalidad;

/**
 * Observar como este objeto de dominio es diferente al Vehiculo que tenemos implementado
 * en el modulo Peaje.
 * Los objetos del dominio, dentro de cada modulo, se adaptan al contexto del problema.
 *
 * No importa tener objetos repetidos, ya que estamos priorizando el bajo acoplamiento.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "Vehiculo_Gestion") //no puedo tener dos entidades que se llamen igual, aunque las mismas
//esten en diferentes paquetes
//no permitimos dos autos con misma matrícula
@Table (name = "gestion_vehiculo", indexes = @Index (columnList = "matricula"))
public class Vehiculo {

    @Id
    private long tag; //el número de tag no lo determina este Sistema,

    private String marca;
    private String modelo;
    private String matricula; //de forma intencionada no uso el objeto identificador en este módulo,
    private Nacionalidad nacionalidad;

    @ManyToOne //un cliente puede tener muchos autos registrados
    private ClienteTelepeaje cliente;
}
