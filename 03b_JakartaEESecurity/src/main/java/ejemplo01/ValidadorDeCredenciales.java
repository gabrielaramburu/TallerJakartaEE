package ejemplo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

/**
 * Implementando la interface IdentityStore, 
 * tenemos control de como autenticar usuarios
 */
@ApplicationScoped
public class ValidadorDeCredenciales implements IdentityStore {
	private HashMap<String, UsuarioSistema> hashUsuarios 
		= new HashMap<String, UsuarioSistema>();
	
	@PostConstruct
	public void inicializar() {
	
		hashUsuarios.put("usr1", new UsuarioSistema("usr1", "usr1pass", 
				new ArrayList<String>(Arrays.asList("grupo1"))));
		
		hashUsuarios.put("usr2", new UsuarioSistema("usr2", "usr2pass", 
				new ArrayList<String>(Arrays.asList("grupo2"))));
		
		hashUsuarios.put("usr3", new UsuarioSistema("usr3", "usr3pass", 
				new ArrayList<String>(Arrays.asList("grupo1", "grupo2"))));
	}

	/**
	 * Lógica del proceso de autenticación
	 */
	@Override
	public CredentialValidationResult validate(Credential credencial) {
		UsernamePasswordCredential creden = (UsernamePasswordCredential)credencial;
		//nunca jamas logear claves
		String usuario = creden.getCaller();
		System.out.println("Usuario: " + usuario);
		//tampoco cargar claves a variables ya que las mismas se pueden en tiempo
		//de ejecucion con herramientas de profiling determinadas
		String password = creden.getPasswordAsString();
		System.out.println("Password: " + password);
		
		if (hashUsuarios.get(usuario) != null) {
			//el usuario exites
			if (hashUsuarios.get(usuario).getPass().equals(password)) {
				//la contraseña es correcta
				ArrayList<String> listaGrupos = hashUsuarios.get(usuario).getGrupos();
				CredentialValidationResult result = 
						new CredentialValidationResult(usuario, new HashSet<>(listaGrupos));
				//al proceso de autorización le interasa saber los grupos a los que pertenece el usuario
				return result;
			} else {
				System.out.println("Contraseña invalida");
				return CredentialValidationResult.INVALID_RESULT;
			}
			
		} else {
			System.out.println("Usuario no existe"); 
			return CredentialValidationResult.INVALID_RESULT;
		}
	
	}


	@Override
	public int priority() {
		return 50;
	}

	

}
