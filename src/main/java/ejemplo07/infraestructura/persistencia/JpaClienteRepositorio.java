package ejemplo07.infraestructura.persistencia;

import java.util.ArrayList;
import java.util.List;

import ejemplo07.dominio.Cliente;
import ejemplo07.dominio.ClienteRepositorio;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JpaClienteRepositorio implements ClienteRepositorio {

	//en la vida real esto será JPA
	private List<Cliente> clientes;
	
	@PostConstruct
	private void cargar() {
		clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("Juan"));
		clientes.add(new Cliente("Pedro"));
		clientes.add(new Cliente("Raquel"));
	}
	
	@Override
	public List<Cliente> findAll() {
		return clientes;
	}

	@Override
	public void agregar(Cliente cliente) {
		clientes.add(cliente);
	}

}
