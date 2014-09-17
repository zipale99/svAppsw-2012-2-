/**
 * Oggetto ConcreteComponent, implementa l'interfaccia di User e rappresenta la generalizzazione per i diversi tipi di utenti
 * Customer e TA.
 * 
 * TO-DO: Gerarchia degli utenti Customer e TA a partire da questa classe.
 *  
 */
package decorator;

/**
 * @author Alessandro
 *
 */
public class User extends AbstractUser{
	
	String username;
	String pwd;
	String ruolo;
	
	public User(String username, String pwd, String ruolo) {
		this.username = username;
		this.pwd = pwd;
		this.ruolo = ruolo;
	}
	
	public User() {
		username = null;
		pwd = null;
		ruolo = null;		
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPwd() {
		// TODO Auto-generated method stub
		return pwd;
	}
	
	@Override
	public String getRuolo() {
		// TODO Auto-generated method stub
		return ruolo;
	}
	
	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}
	
	@Override
	public void setPwd(String pwd) {
		// TODO Auto-generated method stub
		this.pwd = pwd;
	}
	
	@Override
	public void setRuolo(String ruolo) {
		// TODO Auto-generated method stub
		this.ruolo = ruolo;
	}
	
}
