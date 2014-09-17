/**
 * Rappresenta la classe delle Attività.
 */
package resources;

/**
 * @author utente
 *
 */
public class Activity {
	
	int idActivity;
	String type;
    String location;
    String desc;
    int durata;
    double price;
    int timeOffset;
    boolean obbligatoria; //Verificare quale tipo restituisce il db.


    public Activity(int idActivity, String type, String location, String desc, int durata, float price, int timeOffset, boolean obbligatoria) {
		this.idActivity = idActivity;
		this.type = type;
		this.location = location;
		this.desc = desc;
		this.durata = durata;
		this.price = price;
		this.timeOffset = timeOffset;
		this.obbligatoria = obbligatoria;
	}
    
    public Activity() {
    	
    }


	public int getIdActivity() {
		return idActivity;
	}


	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getDurata() {
		return durata;
	}


	public void setDurata(int durata) {
		this.durata = durata;
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


	public boolean isObbligatoria() {
		return obbligatoria;
	}


	public void setObbligatoria(boolean obbligatoria) {
		this.obbligatoria = obbligatoria;
	}

	
    


}
