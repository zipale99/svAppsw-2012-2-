/**
 * Oggetto Aggregate/Component, rappresenta l'interfaccia per le operazioni di Utente generico 
 * o per un utente arricchito con la funzionalità di Creator
 */
package decorator;

/**
 * @author Alessandro
 *
 */
public abstract class AbstractUserComponent {
	
	public abstract String getUsername();
	public abstract String getPwd();
	public abstract String getRuolo();
	
}
