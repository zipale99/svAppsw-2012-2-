/**
 * Allo stesso modo del ConcretComponent, anche la classe DecoratorUser implementa l'interfaccia AbstracUser, ha il compito di decorare l'oggetto User
 * con i ConcreteDecorator(Creator)
 * 
 * Per l'implementazione del singleton, è stato utilizzato un metodo statico (decora) che deve essere chiamato per restituire
 * l'istanza del decoratorUser. L'oggetto decoratorUser verrà istanziato solo la prima volta che il metodo è invocato.
 * Le volte successive sarà restituito un riferimento allo stesso oggetto.
 */
package decorator;

import java.util.ArrayList;
import java.util.List;

import resources.ServiceDB;
import composite.*;

/**
 * @author Alessandro
 *
 */
public abstract class DecoratorUser extends AbstractUserComponent {
	
	
	protected User user; //Riferimento al user
	private Itinerary itinerary;
	
	private static DecoratorUser instance = null; //Riferimento a un istanza di se stessa
	
	//Questo costruttore viene utilizzato solo allo scopo di assegnare la decorazione al user
	public DecoratorUser(User user) { 
		this.user = user; //Assegno la decorazione al user
	}
	
	public static DecoratorUser decora(User user){
	        if(instance == null){
	        	System.out.println("Creo e restituisco una nuova instanza del DecoratorUser specifico");
	        	if (user.getRuolo().equals("Customer"))
	        		instance = new CreatorCustomerDecorator(user);
	        	if (user.getRuolo().equals("TA"))
	        		instance = new CreatorTADecorator(user);
	        }
	        return instance;
	}
	
	public void invalida() {
		instance = null;
	}
	
	 public void createItinerary(){
		 itinerary = new Itinerary();
	 }
	 

	
	
	 
	
	
	public String getRuolo() {
		return user.getRuolo();
	}
	
	public String getUsername() {
		return user.getUsername();
	}
	
	public String getPwd() {
		return user.getPwd();
	}
	
	public User getUser() {
		return user;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
	/*Prima volta che lo chiama decUser smista l'operazione e ritorna il decorator appropriato
	 * Quanod sarachiamato una seconda volta, viene invocato il metodo create del concrete dec appropriato
	 * che restituisce l'istanza creata in precedenza. Dunque è il costruttore del concrete dec che deve tenere traccia 
	 * dell'istanza ed eventualmente restituire l'istanza vecchia.
    */

}
