package ejemplo04;

import jakarta.enterprise.context.ApplicationScoped;

//Las clases que queremos decorar tienen que implementar una interface
//Programar utilizando interfaces es una buena práctica de programación:

//Programming to Interface Vs to Implementation
@ApplicationScoped
public class ServicioClienteImpl implements ServiciosClientes{

	@Override
	public void procesarPagoClientes() throws Exception {
		System.out.println("Procesando pagos a clientes.");
		throw new Exception("Algo no esta funcionado bien");
		
	}

	//El objeto que queremos Decorar puede tener muchos métodos
	//No tenemos que decorar todos
	@Override
	public void procesarComprasClientes() {
		System.out.println("Procesando compra de Clientes.");
		
	}

}
