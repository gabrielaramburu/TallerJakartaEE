package ejemplo03;

public class NotificadorProduccionMail implements NotificadorPago {

	@Override
	public boolean notificar(int destinatario, String mensaje) {
		System.out.println("PROD: Notificando pago a cliente  por correo " + destinatario + " " + mensaje);
		return true;
	}

}
