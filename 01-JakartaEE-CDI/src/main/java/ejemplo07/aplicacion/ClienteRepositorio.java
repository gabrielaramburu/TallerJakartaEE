package ejemplo07.aplicacion;

import java.util.List;

import ejemplo07.dominio.Cliente;

public interface ClienteRepositorio {
	List<Cliente> findAll();
	void agregar(Cliente cliente);
	//otras operaciones contra el repositorio
}
