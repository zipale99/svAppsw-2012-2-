package decorator;

public class CreatorTADecorator extends DecoratorUser {

	public CreatorTADecorator(User user) { //Decoro con la funzionalità di creator
		super(user);
	}
	
	public String getRuolo() {
		//super.getRuolo(); per conoscere il ruolo di prima
		return "CreatorTA";
	}
	
	/*
	 * public String getRuolo() {
		//super.getRuolo(); per conoscere il ruolo di prima
		return "Creator" + super.getRuolo();
	}
	 */
}

