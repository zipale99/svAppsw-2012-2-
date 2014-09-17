package decorator;

public class CreatorCustomerDecorator extends DecoratorUser {
	
	public CreatorCustomerDecorator (User user){
		super(user);
    }
	
	public String getRuolo() {
		//super.getRuolo(); per conoscere il ruolo di prima
		return "CreatorCustomer";
	}
	
	
	/*
	 * public String getRuolo() {
		//super.getRuolo(); per conoscere il ruolo di prima
		return "Creator" + super.getRuolo();
	}
	 */
	
}
