package ejemplo00.aplicacion;

public interface MensajeServicios {
	public String enviarMensaje(String texto);
	public String enviarMensajeComoGerente(String texto);
	public String enviarMensajeComoEmpleado(String texto);
}
