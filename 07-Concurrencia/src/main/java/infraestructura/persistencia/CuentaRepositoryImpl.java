package infraestructura.persistencia;

import application.CuentaRepository;
import domain.Cuenta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class CuentaRepositoryImpl implements CuentaRepository{
	@PersistenceContext
	private EntityManager em;
	
	public Cuenta findById(int idCuenta) {
		String sql = "select c from Cuenta c where c.idCuenta= :idCuenta";

        TypedQuery<Cuenta> findById = em.createQuery(sql, Cuenta.class).setParameter("idCuenta", idCuenta);
        try {
            return findById.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
	}
	
	
	public void actualizar(Cuenta c) {
		em.merge(c);
	}


	@Override
	public void crearCuenta(Cuenta cuenta) {
		em.persist(cuenta);
		
	}
}
