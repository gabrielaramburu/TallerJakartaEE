package ejemplo03;

public class NotificadorTesting implements NotificadorPago {

	@Override
	public boolean notificar(int destinatario, String mensaje) {
		System.out.println("TEST: Notificando el cliente " + destinatario + " " + mensaje);
		return true;
	}

}
