/**
 * Allo stesso modo del ConcretComponent, anche la classe DecoratorUser implementa l'interfaccia AbstracUser, ha il compito di decorare l'oggetto User
 * con i ConcreteDecorator(Creator)
 * 
 * Per l'implementazione del singleton, è stato utilizzato un metodo statico (decora) che deve essere chiamato per restituire
 * l'istanza del decoratorUser. L'oggetto decoratorUser verrà istanziato solo la prima volta che il metodo è invocato.
 * Le volte successive sarà restituito un riferimento allo stesso oggetto.
 */
package decorator;

/**
 * @author Alessandro
 *
 */
public abstract class DecoratorUser extends AbstractUserComponent {
	
	protected AbstractUserComponent component; //Riferimento al component
	private static DecoratorUser instance = null; //Riferimento a un istanza di se stessa
	
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
	 	
	 
	/*Prima volta che lo chiama decUser smista l'operazione e ritorna il decorator appropriato
	 * Quanod sarachiamato una seconda volta, viene invocato il metodo create del concrete dec appropriato
	 * che restituisce l'istanza creata in precedenza. Dunque è il costruttore del concrete dec che deve tenere traccia 
	 * dell'istanza ed eventualmente restituire l'istanza vecchia.
	
	public DecoratorUser create(User user) {
		System.out.println("Metodo create di DecoratorUser");
		if (user != null) {
			if (user.getRuolo().equals("Customer"))
				return new CreatorCustomerDecorator(user);
			else
				return new CreatorTADecorator(user);
		}
		else return null;
	}
	
	
	/*
	public static DecoratorUser create(User user){
        if(instance == null){
        	System.out.println("Creo l'istanza di DecoratorUser");
        	if (user.getRuolo().equals("Customer"))
        		instance = new CreatorCustomerDecorator(user);
        	else
        		instance = new CreatorTADecorator(user);
        }
        return instance;
    }
    */
	
	//Questo costruttore viene utilizzato solo allo scopo di assegnare la decorazione al component
	public DecoratorUser(AbstractUserComponent component) { 
		this.component = component; //Assegno la decorazione al component
	}
	
	
	public String getRuolo() {
		return component.getRuolo();
	}
	
	public String getUsername() {
		return component.getUsername();
	}
	
	public String getPwd() {
		return component.getPwd();
	}
}
