package ejemplo00.infraestructura.persistencia;

import ejemplo00.dominio.Movimiento;
import ejemplo00.dominio.repositorios.MovimientoRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MovimientoRepositorioImpl implements MovimientoRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int altaMovimiento(Movimiento movimiento) {
        em.persist(movimiento);
        System.out.println("Nuevo movimiento: " + movimiento.toString());
        return movimiento.getId();
    }

}
