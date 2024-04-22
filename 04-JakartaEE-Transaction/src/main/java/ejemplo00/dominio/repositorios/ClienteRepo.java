package ejemplo00.dominio.repositorios;

import ejemplo00.dominio.Cliente;
import ejemplo00.dominio.Movimiento;

public interface ClienteRepo {
    public void insertarCliente(Cliente cliente);
    public Cliente buscaClientePorId(int id);

    public Cliente actualizar(Cliente cliente);

}
