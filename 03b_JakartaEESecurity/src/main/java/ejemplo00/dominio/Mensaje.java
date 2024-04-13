package ejemplo00.dominio;

public class Mensaje {
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Mensaje(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public Mensaje() {
		
	}
	
	public String mostrar() {
		try {
			//simulo que hago algo algún trabajo
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "El contenido del mensaje es: " + this.mensaje + "\n";
	}
}
