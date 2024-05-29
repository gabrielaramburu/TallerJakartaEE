package org.tallerjava.moduloGestion.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.tallerjava.moduloGestion.dominio.Vehiculo;
import org.tallerjava.moduloGestion.dominio.repo.UsuarioRepositorio;
import org.tallerjava.moduloGestion.dominio.usuario.Usuario;

@ApplicationScoped
public class UsuarioRepositorioImpl implements UsuarioRepositorio {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Vehiculo findByTag(int tag) {
        String sql = "select v from Vehiculo_Gestion v where v.tag= :tag";

        TypedQuery<Vehiculo> findByTag = em.createQuery(sql, Vehiculo.class).setParameter("tag", tag);
        try {
            return findByTag.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
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

    @Override
    public void vincularVehiculo(Vehiculo vehiculo) {
        em.persist(vehiculo);
    }

}
