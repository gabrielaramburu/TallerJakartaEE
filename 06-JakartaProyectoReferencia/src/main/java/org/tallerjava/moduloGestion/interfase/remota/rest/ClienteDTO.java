package org.tallerjava.moduloGestion.interfase.remota.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tallerjava.moduloGestion.dominio.Nacionalidad;
import org.tallerjava.moduloGestion.dominio.usuario.Usuario;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String nombre;
    private String email;
    private int nacionalidad;

    //En este caso, no está mal darle al DTO la responsabilidad de construir
    // su correspondiente objeto de negocio, principalmente porque la función del DTO es la de parsear un json
    public Usuario buildUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre(this.nombre);
        usuario.setEmail(this.email);
        Nacionalidad nacio =
                this.nacionalidad == Nacionalidad.EXTRANJERO.getId()?Nacionalidad.EXTRANJERO:Nacionalidad.NACIONAL;
        usuario.setNacionalidad(nacio);
        return usuario;
    }
}
