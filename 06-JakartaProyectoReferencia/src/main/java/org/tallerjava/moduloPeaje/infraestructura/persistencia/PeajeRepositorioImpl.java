package org.tallerjava.moduloPeaje.infraestructura.persistencia;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import org.tallerjava.moduloPeaje.dominio.*;
import org.tallerjava.moduloPeaje.dominio.repo.PeajeRepositorio;

import java.time.LocalDateTime;
import java.util.Date;

@ApplicationScoped
public class PeajeRepositorioImpl implements PeajeRepositorio {
    private static final Logger log = Logger.getLogger(PeajeRepositorioImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Vehiculo findByTag(int tag) {
        String sql = "select v from Vehiculo v where v.identificador.tag = :tag";

        TypedQuery<Vehiculo> findByTag = em.createQuery(sql, Vehiculo.class).setParameter("tag", tag);
        try {
            return findByTag.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Vehiculo findByMatricula(String matricula) {

        String sql = "select v from Vehiculo v where v.identificador.matricula = :matricula";
        TypedQuery<Vehiculo> findByTag = em.createQuery(sql, Vehiculo.class).setParameter("matricula", matricula);
        try {
            return findByTag.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Preferencial obtenerTarifaPreferencial() {
        TypedQuery<Preferencial> findLatest = em.createQuery(
                "select t from Preferencial t order by t.fechaAplicacion desc ", Preferencial.class);
                 findLatest.setMaxResults(1);
        try {
            return findLatest.getSingleResult();
        } catch (NoResultException e) {
            log.error("Error de inconsistencia de datos, siempre tiene que existir una tarifa Preferencial.");
            return null;
        }
    }

    @Override
    public Comun obtenerTarifaComun() {
        TypedQuery<Comun> findLatest = em.createQuery(
                "select t from Comun t order by t.fechaAplicacion desc ", Comun.class);
        findLatest.setMaxResults(1);
        try {
            return findLatest.getSingleResult();
        } catch (NoResultException e) {
            log.error("Error de inconsistencia de datos, siempre tiene que existir una tarifa Comun.");
            return null;
        }
    }
}
