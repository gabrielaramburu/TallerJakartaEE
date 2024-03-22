package ejemplo05;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Traductor {
	@Inject
	private TraductorExterno traductorExterno;
	
	public Traductor( ) {
		//no confundir con Constructores comunes
	}
	private List<Lenguaje> lenguajes;
	
	//El contenedor maneja el ciclo de vida de los componentes (managed beans)
	//Algo similar como lo hace la máquina virtual con los objetos 
	//Luego de que el objeto sea instanciado, y que todas sus dependencias sean injectadas
	//pero antes de que el mismo esté disponible para sus cliente
	//se ejecuta este método
	@PostConstruct
	private void cargarLenguajes() {
		System.out.println("Ejecutando PostConstruct ");
		//notar que el uso de new sigue teniendo vigencia
		//en ejemplos posteriores veremos esto con mayor detalle
		lenguajes = new ArrayList<Lenguaje>();
		
		lenguajes.add(new Lenguaje(1, "Español"));
		lenguajes.add(new Lenguaje(2, "Ingles"));
		lenguajes.add(new Lenguaje(3, "Portugues"));
		
		//este comportamiento no lo tengo disponible en el Constructor del objeto
		if (traductorExterno != null) {
			lenguajes.add(new Lenguaje(4, traductorExterno.obtenerLenguaje()));
		}
		
	}
	
	@PreDestroy
	private void destruir() {
		//Su uso es más residual
		System.out.println("Destruyendo bean");
	}
	
	public List<Lenguaje> lenguajesDisponibles(){
		return this.lenguajes;
	}
}
