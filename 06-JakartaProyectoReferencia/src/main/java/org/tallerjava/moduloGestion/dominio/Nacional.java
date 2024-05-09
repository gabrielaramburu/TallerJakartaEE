package org.tallerjava.moduloGestion.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Nacional extends Usuario{
    private ClienteSucive clienteSucive;

    public Nacional (long id, String nombre, String email,
                     List<Vehiculo> vehiculosAsociados,
                     ClienteTelepeaje cliTelepeaje) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.vehiculosAsociados = vehiculosAsociados;
        this.clienteTelepeaje = cliTelepeaje;
    }

    @Override
    public boolean soyNacional() {
        return true;
    }
}
