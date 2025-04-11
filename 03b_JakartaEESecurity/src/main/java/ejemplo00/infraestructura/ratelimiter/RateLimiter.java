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
		
		// El balde tiene un capacidad inicial de 10
		// cada vez que llega un request, se quita un elemento del balde
		// si el balde se queda vacío los request serán rechazados
		
		
		Bandwidth bucketConf = Bandwidth.builder()
				.capacity(10) //capacidad inicial
				.refillGreedy(7, Duration.ofSeconds(1))
				// el balde se intentará llenar con 5 tokens en un lapso de 1 segundo
				// intentando distribuir el llenado de forma regular, es decir:
				//no va a esperar 1 segundo para cargar los 5 tokens sino que un nuevo
				//tocken se creara cada cada 200 milisegundos (1/5=0,200)
				
				//Esto se traduce en lo siguiente:
				//trabajando a su máxima capacidad aceptará como máximo 5 TPS 
				//(ya que la taza de reposición así lo establece)
				
				//si quiero procesar 10 TPS refillGreedy(10, Duration.ofSeconds(1))
				
				
				//.refillIntervally(5, Duration.ofSeconds(1))
				//esta idea es más simple, no intenta llenar el balse de forma regular, 
				//sino que lo llena de golpe cuando finaliza el período de tiempo
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
