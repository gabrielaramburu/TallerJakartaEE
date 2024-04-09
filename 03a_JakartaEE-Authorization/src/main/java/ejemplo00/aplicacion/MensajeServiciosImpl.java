package ejemplo00.aplicacion;

import ejemplo00.dominio.Mensaje;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MensajeServiciosImpl implements MensajeServicios {

	
	@Override
	public String enviarMensaje(String texto) {
		Mensaje msg = new Mensaje(texto);
		String msgFinal = msg.mostrar();
		return msgFinal;
	}


	@Override
	public String enviarMensajeComoGerente(String texto) {
		Mensaje msg = new Mensaje(texto);
		String msgFinal = "Mensaje enviado por gerente: " + msg.mostrar();
		return msgFinal;
	}

	@Override
	public String enviarMensajeComoEmpleado(String texto) {
		Mensaje msg = new Mensaje(texto);
		String msgFinal = "Mensaje enviado por empleado: " + msg.mostrar();
		return msgFinal;
	}

}
