/**
 * 
 */
package composite;


/**
 * @author utente
 *
 */
public class Itinerary extends StayTemplateComposite{

	String user;
	String desc;
	String categoria;
	String stato;
	
	public Itinerary() {
		
	}
	
	
	public Itinerary(String user, String startLoc, String endLoc, int durata, String nome, String desc, String categoria, String stato, double price) {
		super(startLoc, endLoc, durata, nome, price, null);
		this.user = user;
		this.desc = desc;
		this.categoria = categoria;
		this.stato = stato;
		this.price = price;
	}
	
	public Itinerary(String user, String nome, String desc, String categoria) {
		this.user = user;
		this.nome = nome;
		this.desc = desc;
		this.categoria = categoria;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	

	/*
	@Override
	public String toString() {
		return "Stato: " + stato +
				"; Tipologia: " + type +
				"; startLoc: " + startLoc +
				"; endLoc: " + endLoc +
				"; durata: " + durata +
				"; nome: " + nome +
				"; desc: " + desc +
				super.toString();
	}
	*/






	
	
	
}

