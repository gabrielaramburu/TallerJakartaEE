package org.tallerjava.moduloGestion.dominio.repo;

import jakarta.enterprise.context.ApplicationScoped;
import org.tallerjava.moduloGestion.dominio.Vehiculo;
import org.tallerjava.moduloGestion.dominio.usuario.Usuario;


public interface UsuarioRepositorio {
    /**
     * Devuelve el usuario asignado al vehiculo
     * @param tag
     * @return
     */
    public Vehiculo findByTag(int tag);

    public long save(Usuario usuario);

    public Usuario findById(long id);

    void actualizarUsuario(Usuario usr);

    void vincularVehiculo(Vehiculo vehiculo);
}
