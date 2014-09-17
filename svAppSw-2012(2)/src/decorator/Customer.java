package decorator;

public class Customer extends User {
	
	public Customer(String nomeUtente, String pwd) {
		super(nomeUtente, pwd, "Customer");
	}
	
	@Override
	public String getRuolo() {
		return "Customer";
	}
	
}
