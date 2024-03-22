package ejemplo07.dominio;

import java.util.List;

public interface ClienteRepositorio {
	List<Cliente> findAll();
	void agregar(Cliente cliente);
	//otras operaciones contra el repositorio
}
