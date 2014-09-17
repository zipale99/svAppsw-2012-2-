package resources;

import java.util.ArrayList;
import java.util.List;
import composite.Itinerary;

public class ElencoItineraryBean {

    private List<Itinerary> elencoItinerari;    
    
    /**
     * senza argomenti come da regola dei Bean
     **/
    public ElencoItineraryBean() {
		elencoItinerari = new ArrayList<Itinerary>();
	}
    
    
    public List<Itinerary> getElencoItinerari(){
		return elencoItinerari;
	}
    
    
    public void aggiungi(int id,String user,String startLoc,String endLoc, int durata,String name,String desc,String stato,double prezzo){
		Itinerary it = new Itinerary();
		it.setId(id);
		it.setUser(user);
		it.setStartLoc(startLoc);
		it.setEndLoc(endLoc);
		it.setDurata(durata);
		it.setNome(name);
		it.setDesc(desc);
		it.setStato(stato);
		it.setPrice(prezzo);
		elencoItinerari.add(it);
	}
	
}
