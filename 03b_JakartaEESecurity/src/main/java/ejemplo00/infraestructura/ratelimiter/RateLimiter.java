package ejemplo00.infraestructura.ratelimiter;

import java.time.Duration;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Rate limiter del tipo token bucket
 */
@ApplicationScoped
public class RateLimiter {
	
	private Bucket bucket;
	private boolean activo;
	
	@PostConstruct
	public void inicializar() {
		activo = true;
		
		// el balde tiene un capacidad inicial de 10
		// cada vez que llega un request, se quita un elemento del balde
		// si el balde se queda vacío los request serán rechazados
		// el valde se intentará llenear con 60 tocken en un lapso de 1 minutos
		// intentando distribuir el llenado en intervalos regulares (un
		// nuevo tocken cada 1 segundo)
		
		//esto se traduce en lo siguiente:
		//en cualquire momento, el servidor podrá procesar un máximo de 10 transacciones concurrentes
		//trabajando a su máxima capacidad aceptará una nueva 1 transación por segundo
		Bandwidth bucketConf = Bandwidth.builder()
				.capacity(10)
				.refillGreedy(60, Duration.ofSeconds(30))
				.build();
		
		bucket=Bucket.builder().addLimit(bucketConf).build();
	}
	
	public boolean  consumir() {
		boolean result = bucket.tryConsume(1);
		System.out.println("Tockens restantes: " + bucket.getAvailableTokens());
		return result;
	}
	
	public void activarRateLimiter(boolean estado) {
		System.out.println("Ratelimitir estado: " + estado);
		this.activo = estado;
	}

	public boolean isActivo() {
		return this.activo;
	}
}
