package ramelimiter;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;

public class TocketBucketMain {
	private static Bucket bucket;
	private static int contador = 0;

	public static void main(String[] args) {
		// el balde tiene un capacidad inicial de 10
		// cada vez que llega un request, se quita un elemento del balde
		// si el balde se queda vacío los request serán rechazados
		// el valde se intentará llenear con 10 tocken en un lapso de 1 minutos
		// intentando distribuir el llenado en intervalos regulares (cada 6 segundos un
		// nuevo tocken)
		Bandwidth bucketConf = Bandwidth.builder().capacity(10).refillGreedy(10, Duration.ofMinutes(1)).build();
		bucket = Bucket.builder().addLimit(bucketConf).build();

		while(contador < 100) {
			hacerAlgo("accion " + contador);
			hacerPausa(1000); //cada un segundo emito una nueva acción 
		}
		
		//las primeras diez accioens no tienen problema ya que el valde tiene tokens
		//una vez que se consumen los tockens, se agregará uno nuevo cada 6 segundos aprox

	}

	private static void hacerAlgo(String accion) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
		incrementarContador();
		Runnable hilo = () -> {
			boolean consumido = bucket.tryConsume(1);
			if (consumido) {
				System.out.println("Realizando:" + accion + ", " + formatter.format(new Date()));
				hacerPausa(500);
			}
			else
				System.out.println("No realizando:" + accion);
			
		};
		new Thread(hilo).start();
	}
	
	private static void hacerPausa(int pausa) {
		try {
			Thread.sleep(pausa);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void incrementarContador() {
		synchronized (bucket) {
			contador++;
		}
		
	}
}
