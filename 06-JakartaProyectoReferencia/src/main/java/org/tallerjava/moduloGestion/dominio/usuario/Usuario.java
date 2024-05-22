package org.tallerjava.moduloGestion.dominio.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tallerjava.moduloGestion.dominio.Nacionalidad;
import org.tallerjava.moduloGestion.dominio.Vehiculo;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "gestion_usuario")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected long id;

    protected String nombre;
    protected String email;
    protected Nacionalidad nacionalidad;

    @Transient //no quiero manejar las dependencias one to many
    protected List<Vehiculo> vehiculosAsociados;

    @OneToOne
    protected ClienteTelepeaje clienteTelepeaje;

    public boolean soyNacional() {
        return nacionalidad.getId() == Nacionalidad.NACIONAL.getId()? true : false;
    }

    public void cargarSaldo(double importe) {
        this.clienteTelepeaje.cargarSaldo(importe);
    }

    public double consultarSaldo() {
        return this.clienteTelepeaje.consultarSaldo();
    }
}
