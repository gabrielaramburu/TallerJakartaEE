package org.tallerjava.moduloGestion.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.tallerjava.moduloPeaje.dominio.Identificador;
import org.tallerjava.moduloPeaje.dominio.Nacionalidad;

/**
 * Observar como este objeto de dominio es diferente al Vehiculo que tenemos implementado
 * en el modulo Peaje.
 * Los objetos del dominio, dentro de cada modulo, se adaptan al contexto del problema.
 *
 * No importa tener objetos repetidos, ya que estamos priorizando el bajo acoplamiento.
 */
@Data
@AllArgsConstructor
public class Vehiculo {
    private long id;
    private Identificador identificador;
    private ClienteTelepeaje cliente;
}
