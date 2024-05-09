package org.tallerjava.moduloGestion.dominio.repo;

import org.tallerjava.moduloGestion.dominio.Cuenta;
import org.tallerjava.moduloGestion.dominio.Usuario;

import java.util.List;

public interface UsuarioRepositorio {
    /**
     * Devuelve el usuario asignado al vehiculo
     * @param tag
     * @return
     */
    public Usuario findByTag(int tag);

}
