package ejemplo00.aplicacion;

import ejemplo00.dominio.Cliente;
import ejemplo00.dominio.Movimiento;
import ejemplo00.dominio.exception.SaldoInsuficienteException;
import ejemplo00.dominio.repositorios.ClienteRepo;
import ejemplo00.dominio.repositorios.MovimientoRepo;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CuentaServiciosImpl implements CuentaServicios {

    @Inject
    private ClienteRepo clienteRepo;
    @Inject
    private MovimientoRepo movRepo;

    @Override
    public List<Cliente> obtenerClientes() {
        return List.of(new Cliente(2,"jose",500, null));
    }
    @Override
    @Transactional
    public void insertarCliente(Cliente cliente) {
        clienteRepo.insertarCliente(cliente);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public int nuevoMovimiento(int idCliente, Movimiento mov) throws SaldoInsuficienteException {
        Cliente cli = clienteRepo.buscaClientePorId(idCliente);
        System.out.println("encontrado " + cli.toString());

        mov.setCliente(cli);

        System.out.println("movimiento " + mov.toString());
        int nuevoModId = movRepo.altaMovimiento(mov);

        cli.actualizarSaldo(mov);
        clienteRepo.actualizar(cli);
        return nuevoModId;
    }





}
