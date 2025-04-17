package infraestructura.persistencia;

import application.concurrente.CuentaConcurrenteRepository;
import domain.Cuenta;
import domain.CuentaConcurrente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Vetoed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.NoResultException;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class CuentaConcurrenteRepositoryImpl implements CuentaConcurrenteRepository{
	@PersistenceContext
	private EntityManager em;
	
	public CuentaConcurrente findById(int idCuenta) {
		String sql = "select c from CuentaConcurrente c where c.idCuenta= :idCuenta";

        TypedQuery<CuentaConcurrente> findById = em.createQuery(sql, CuentaConcurrente.class).setParameter("idCuenta", idCuenta);
        
        //Acá establezco el tipo de bloqueo
        //https://www.baeldung.com/jpa-optimistic-locking
        findById.setLockMode(LockModeType.OPTIMISTIC);
        
        //https://www.baeldung.com/jpa-pessimistic-locking
        //findById.setLockMode(LockModeType.PESSIMISTIC_WRITE);
        try {
            return findById.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
	}
	
	
	public void actualizar(CuentaConcurrente c) {
		
		em.merge(c);
		
	}


	@Override
	public void crearCuenta(CuentaConcurrente cuenta) {
		em.persist(cuenta);
		
	}
}
