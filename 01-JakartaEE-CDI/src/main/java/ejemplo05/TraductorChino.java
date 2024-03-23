package ejemplo05;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TraductorChino implements TraductorExterno {

	@Override
	public String obtenerLenguaje() {
		return "Chino";
	}

}
