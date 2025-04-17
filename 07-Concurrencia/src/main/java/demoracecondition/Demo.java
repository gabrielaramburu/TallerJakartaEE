package demoracecondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.spi.SyncResolver;

/**
 * Este ejemplo es para demostrar que los problemas de concurrencia no son exlusivos de las base de datos.
 * Son problemas que aplican siempre que utilice un recurso compartido y tenga más de un hilo de ejecución
 * modificando/accediendo al mismo.
 * 
 * La programación concurrente es una rama de la imformática que requiere un estudio por si solo.
 */
public class Demo {

	public static void main(String[] args) throws InterruptedException {
		CuentaBancaria cuenta = new CuentaBancaria(1000);
		System.out.println("Saldo inicial: " + cuenta.getSaldo() + "S");

		// Creamos un pool de 2 hilos
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// Ejecutamos 2 operaciones concurrentes
		executor.submit(new OperacionBancaria(cuenta, 500, "Depósito"));
		executor.submit(new OperacionBancaria(cuenta, -200, "Retiro"));

		// Esperamos a que terminen los hilos
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);

		// Resultado final (debería ser 1300S, pero habrá inconsistencia)
		
		//Si ejecutamos muchas veces este código obtendremos varias salidas
		//es posible que alguna de ellas sea correcta
		System.out.println("Saldo final: " + cuenta.getSaldo() + "$");
	}
}

/**
 * Este es el "recurso compartido", es el mismo rol que tiene una base de datos.
 * Recordar que las race condition se da cuando hay varios hilos, accediendo a recursos compartidos.
 */
class CuentaBancaria {
	private double saldo;

	public CuentaBancaria(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	// para evitar los race conditios hay que sincronizar este código
	// cuando sincronizamos el mismo hacemos que la JVM se encarge de que solo un hilo a la vez, 
	//ejecute el mismo. Decimos que establecemos un mecanismo de exlusión mutua.
	
	public synchronized void  modificarSaldo(double cantidad) {
	//public void modificarSaldo(double cantidad) {
		double nuevoSaldo = saldo + cantidad; //accediendo al recurso compartido

		// Simulamos un pequeño retraso para forzar la race condition
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		this.saldo = nuevoSaldo;
	}

	public double getSaldo() {
		return saldo;
	}
}

/**
 * Esta clase represeta un thread o hilo de ejecución. Este código va a estar ejecutándose muchas veces
 * de forma concurrente ya que se iniciarian varios hilos.
 */
class OperacionBancaria implements Runnable {
	private final CuentaBancaria cuenta;
	private final double cantidad;
	private final String operacion;

	public OperacionBancaria(CuentaBancaria cuenta, double cantidad, String operacion) {
		this.cuenta = cuenta;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}

	@Override
	public void run() {
		System.out.println(
				Thread.currentThread().getName() 
				+ " - Iniciando " + operacion + " de " + Math.abs(cantidad) + "$");

		cuenta.modificarSaldo(cantidad);

		System.out.println(
				Thread.currentThread().getName() + " - " + operacion + " completado. "
						+ "Saldo temporal: "+ cuenta.getSaldo() + "$");
	}
}
