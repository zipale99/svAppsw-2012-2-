/**
 * Questa classe astratta rappresenta il Component, è estesa da StayTemplateLeaf e da StayTemplateComposite
 */
package composite;

/**
 * @author utente
 *
 */
public abstract class StayTemplate {
	
	int id;
	String startLoc;
	String endLoc;
	int durata;
	String nome;
	double price;
	int timeOffset;

	
	/*
	 * Costruttore di default, viene chiamato da StayTemplateComposite quando 
	 * viene creato un composite per la realizzazione di un itinerario
	 */
	public StayTemplate() {
	}
	
	public StayTemplate(String startLoc, String endLoc, int durata, String nome, double price, int timeOffset) {
		this.startLoc = startLoc;
		this.endLoc = endLoc;
		this.durata = durata;
		this.nome = nome;
		this.price = price;
		this.timeOffset = timeOffset;
	}
	
	
	public abstract void add(StayTemplate st);
	//public abstract void remove(StayTemplate st);
	
	@Override
	public String toString() {
		return  "\nstartLoc: " + startLoc +
				"\nendLoc: " + endLoc +
				"\ndurata: " + durata +
				"\nnome: " + nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartLoc() {
		return startLoc;
	}

	public void setStartLoc(String startLoc) {
		this.startLoc = startLoc;
	}

	public String getEndLoc() {
		return endLoc;
	}

	public void setEndLoc(String endLoc) {
		this.endLoc = endLoc;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTimeOffset() {
		return timeOffset;
	}

	public void setTimeOffset(int timeOffset) {
		this.timeOffset = timeOffset;
	}
	
		
}
