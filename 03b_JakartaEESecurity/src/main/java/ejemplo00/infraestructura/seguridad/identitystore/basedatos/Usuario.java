package ejemplo00.infraestructura.seguridad.identitystore.basedatos;

import java.util.ArrayList;
import java.util.List;

import ejemplo00.infraestructura.seguridad.HashFunctionUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	private String username;
	private String passwordHash; //
	
	//https://www.baeldung.com/hibernate-initialize-proxy-exception
	@ManyToMany (fetch = FetchType.EAGER)
	private List<Grupo> grupos;
	
	/**
	 * Esto se podría reescribir usando programación funcional 
	 * Ver uso de streams en Java
	 * @return
	 */
	public List<String> gruposAsString() {
		List<String> grupos = new ArrayList<String>();
		if (grupos != null) {
			for (Grupo grupo: this.grupos) {
				grupos.add(grupo.getNombre());
			}
		}
		System.out.println("Lista de grupos:" + grupos.toString());
		return grupos;
	}
	
	public boolean contraseniaCorrecta(String pass) {
		return HashFunctionUtil.
				convertToHas(pass).equals(passwordHash)?true:false;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return passwordHash;
	}
	public void setPassword(String password) {
		this.passwordHash = password;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	
	
}
