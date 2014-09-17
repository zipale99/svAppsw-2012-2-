/**
 * Rappresenta la tipologia Hand Made Stay di uno StayTemplateLeaf
 */
package composite;

/**
 * @author utente
 *
 */
public class HandMadeStay extends StayTemplateLeaf {
	
	/*
	 * L'ultimo parametro del costruttore super() vuole una lista di option, 
	 * essendo la tappa manuale priva di opzioni, imposto direttamente il parametro a null
	 */
	public HandMadeStay(String startLoc, String endLoc, String nome) {
		super(startLoc, endLoc, -1, nome, "HMS", -1, -1, null);
	}
	
}
