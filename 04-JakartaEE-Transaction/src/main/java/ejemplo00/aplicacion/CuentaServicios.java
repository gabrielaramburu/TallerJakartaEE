package ejemplo00.aplicacion;

import ejemplo00.dominio.Cliente;
import ejemplo00.dominio.Movimiento;
import ejemplo00.dominio.TipoMovimiento;
import ejemplo00.dominio.exception.SaldoInsuficienteException;

import java.util.List;

public interface CuentaServicios {
    public void insertarCliente(Cliente cliente);
    public List<Cliente> obtenerClientes();
    public int nuevoMovimiento(int idCliente, Movimiento movimiento) throws SaldoInsuficienteException;
    //TODO listar movimientos


}
