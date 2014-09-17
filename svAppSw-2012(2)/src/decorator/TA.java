package decorator;

public class TA extends User {

	public TA(String nomeUtente, String pwd) {
		super(nomeUtente, pwd, "TA");
	}
	
	@Override
	public String getRuolo() {
		return "TA";
	}

}
