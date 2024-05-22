package org.tallerjava.moduloGestion.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.tallerjava.moduloGestion.dominio.repo.UsuarioRepositorio;
import org.tallerjava.moduloGestion.dominio.usuario.Usuario;
import org.tallerjava.moduloPeaje.dominio.Vehiculo;

@ApplicationScoped
public class UsuarioRepositorioImpl implements UsuarioRepositorio {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario findByTag(int tag) {
        return null;
    }

    @Override
    public long save(Usuario usuario) {
        em.persist(usuario.getClienteTelepeaje().getCtaPrepaga());
        em.persist(usuario.getClienteTelepeaje());
        em.persist(usuario);
        return usuario.getId();
    }

    @Override
    public Usuario findById(long id) {
         return em.find(Usuario.class, id);
    }

    @Override
    public void actualizarUsuario(Usuario usr) {
        em.merge(usr);
    }

}
