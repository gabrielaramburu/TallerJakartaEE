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
@Table (name = "gestion_tarjeta")
public class Tarjeta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private int nroTarjeta;
    private String marca; //mejor es tener esto codificado
    private LocalDateTime fechaVto;
    private String nombreCompletoUsuario;
}
