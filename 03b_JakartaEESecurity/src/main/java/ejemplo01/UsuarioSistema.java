package ejemplo01;

import java.util.ArrayList;

public class UsuarioSistema {
	private String usr;
	private String pass; //tendría que ser un hashcode
	private ArrayList<String> grupos;
	
	public UsuarioSistema(String usr, String pass, ArrayList<String> grupos) {
		super();
		this.usr = usr;
		this.pass = pass;
		this.grupos = grupos;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public ArrayList<String> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<String> grupos) {
		this.grupos = grupos;
	}
	
	
}
