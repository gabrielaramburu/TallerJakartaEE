package ejemplo00.infraestructura.seguridad.identitystore.basedatos;

import java.util.HashSet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Vetoed;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
//@Vetoed
public class ValidadorCredencialesDB implements IdentityStore{
	@PersistenceContext
	private EntityManager em;

	@Override
	public CredentialValidationResult validate(Credential credential) {
		System.out.println("** IdentityStore en base de datos");
		CredentialValidationResult resultado = CredentialValidationResult.INVALID_RESULT;
		
		UsernamePasswordCredential credencial = (UsernamePasswordCredential)credential;
		String usr = credencial.getCaller();
		String pass = credencial.getPasswordAsString();
		Usuario usuario = findUsuario(usr); 
		if (usuario != null) {
			System.out.println("encontre usuario: " + usuario.getUsername());
			if (usuario.contraseniaCorrecta(pass)) {
				System.out.println("contraseña correcta");
				//al proceso de autorización le interasa saber los grupos a los que pertenece el usuari
				resultado =  new CredentialValidationResult
						(usr, new HashSet<>(usuario.gruposAsString()));
				
			} else {
				System.out.println("password incorrecta");
			}
		} else {
			System.out.println("No existe usuario.");
		}
		return resultado;
	
	}
	
	private Usuario findUsuario(String nombre) {
		return em.find(Usuario.class, nombre);
	}
	
}
