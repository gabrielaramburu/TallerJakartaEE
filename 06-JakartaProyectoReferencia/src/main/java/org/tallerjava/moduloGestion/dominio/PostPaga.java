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
@Table (name = "gestion_cuentaPostPaga")
public class PostPaga extends Cuenta {

    @OneToOne
    @JoinColumn(name = "idTarjeta", referencedColumnName = "id") //en la tabla PostPaga voy a tener un campo
    //idTarjeta que hace referencia al campo id de la tabla Tarjeta
    //si no indicamos esta información el framework asigna nombres por defecto
    private Tarjeta tarjeta; //eventualmente en el futuro un cliente podrá tener más de una tarjeta registrada

}
