package ejemplo00.infraestructura.persistencia;

import ejemplo00.dominio.Cliente;
import ejemplo00.dominio.Movimiento;
import ejemplo00.dominio.TipoMovimiento;
import ejemplo00.dominio.repositorios.ClienteRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ClienteRepositorioImpl implements ClienteRepo {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void insertarCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public Cliente buscaClientePorId(int id) {
       return em.find(Cliente.class,id);
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        em.persist(cliente);
        return cliente;
    }
}
