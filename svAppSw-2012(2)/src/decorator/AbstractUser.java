/**
 * Subject: Rappresenta l'interfaccia comune a RealSubject(User) e a Proxy(ProxyUser)
 * 
 */
package decorator;

/**
 * @author Alessandro
 *
 */
public abstract class AbstractUser extends AbstractUserComponent {

	public abstract String getPwd();
	public abstract String getRuolo();
	public abstract String getUsername();
	public abstract void setPwd(String pwd);
	public abstract void setRuolo(String ruolo);
	public abstract void setUsername(String username);
	
}
