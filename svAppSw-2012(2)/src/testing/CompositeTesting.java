package testing;
import java.util.ArrayList;
import java.util.List;

import resources.Activity;
import resources.Option;
import resources.OptionValue;
import composite.*;

public class CompositeTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/***************** SISTEMA *****************/
		 
		
		//Creo delle Attività
		Activity attivita1 = new Activity(1, "Culturale", "Roma", "Visita Colosseo", 2, 20, 1, true);
		Activity attivita2 = new Activity(2, "Culturale", "Roma", "Fori romani", 8, 0, 1, false);
		Activity attivita3 = new Activity(3, "Culturale", "Roma", "Pantheon", 1, 10, 1, false);
		Activity attivita4 = new Activity(4, "Culturale", "Torino", "Visita a superga", 3, 15, 1, false);
		Activity attivita5 = new Activity(5, "Culturale", "Torino", "Salita Mole Antoneliana", 1, 10, 1, false);
		Activity attivita6 = new Activity(6, "Culturale", "Torino", "visita alla Cappella della sacra sindone", 1, 10, 1, false);
		Activity attivita7 = new Activity(7, "Culturale", "Milano", "Duomo", 2, 20, 1, false);
		Activity attivita8 = new Activity(8, "Culturale", "Milano", "Navigli", 2, 20, 1, false);
		
		//Compongo dei pacchetti di attività da aggiungere alle tappe che saranno proposte agli utenti
		List<Activity> listaAtt1 = new ArrayList<Activity>();
		List<Activity> listaAtt2 = new ArrayList<Activity>();
		List<Activity> listaAtt3 = new ArrayList<Activity>();
		listaAtt1.add(attivita1);
		listaAtt1.add(attivita2);
		listaAtt1.add(attivita3);
		listaAtt2.add(attivita4);
		listaAtt2.add(attivita5);
		listaAtt2.add(attivita6);
		listaAtt3.add(attivita7);
		listaAtt3.add(attivita8);
		
		//Creo delle opzioni
		Option opt1 = new Option(1, "Servizio in Camera", "Permette di specificare se si vuole il servizio in camera", "NO");
		Option opt2 = new Option(2, "Frigo-bar", "Permette di specificare si vuole il frigo bar", "NO");
		Option opt3 = new Option(3, "Trasporto", "Permette di specificare la tipologia di trasporto", "AUTO");
		Option opt4 = new Option(4, "Pernottamento", "Permette di scegliere una soluzione per il pernottamento", "HOTEL");
		
		//Recupero(creo) una serie di valori per le opzioni appena create
		opt1.add(new OptionValue("SI", 50));
		opt1.add(new OptionValue("NO", 0));
		opt2.add(new OptionValue("SI", 20));
		opt2.add(new OptionValue("NO", 0));
		opt3.add(new OptionValue("AUTO", 200));
		opt3.add(new OptionValue("TRENO", 350));
		opt3.add(new OptionValue("PULMANN", 100));
		opt4.add(new OptionValue("ALBERGO", 200));
		opt4.add(new OptionValue("PENSIONE-COMPLETA", 400));
		opt4.add(new OptionValue("MEZZA-PENSIONE", 250));
		opt4.add(new OptionValue("HOTEL", 300));
		opt4.add(new OptionValue("BED & BREAKFAST", 170));
		
		
		//Creo liste di opzioni da poter aggiungere ai Leaf
		List<Option> listaOpt1 = new ArrayList<Option>();
		List<Option> listaOpt2 = new ArrayList<Option>();
		listaOpt1.add(opt1);
		listaOpt1.add(opt2);
		listaOpt1.add(opt4);
		listaOpt2.add(opt3);
		
		//Creo una serie di leaf con le opzioni associate
		StayTemplateLeaf leaf1 = new Transport("pulmann", "torino", "roma", "6 ore", "to-ro", listaOpt2);
		StayTemplate leaf2 = new Transport("pulmann", "roma", "milano", "4 ore", "to-mi", listaOpt2);
		StayTemplate leaf3 = new Transport("pulmann", "roma", "torino", "2 ore", "to-ud", listaOpt2);
		StayTemplate leaf4 = new Accomodation("Hotel","Bello","5 stelle", "torino", "torino", "2", "to-Acc", listaOpt1);
		
		//creo tappe composite
		StayTemplate tappaComposita1 = new StayTemplateComposite("torino", "milano", "12", "to-mi", listaAtt1);
		StayTemplate tappaComposita2 = new StayTemplateComposite("roma", "torino", "12", "ro-to", listaAtt2);
				
	
		//Compongo le tappe composite
		tappaComposita1.add(leaf1);
		tappaComposita1.add(leaf2);
		
		tappaComposita2.add(leaf1);
		tappaComposita2.add(leaf3);
		tappaComposita2.add(leaf4);		
		
		
		
		/***************** UTENTE *******************/
			
		
		//Creo un nuovo itinerario
		Itinerary itinerario = new Itinerary(2,"parziale","turistico","torino","milano","12","ciao","null","");
		
		itinerario.add(tappaComposita1);
		itinerario.add(leaf2);
		itinerario.add(tappaComposita2);
		itinerario.add(leaf4);
		
		
		
		
		
		//System.out.println("La tappa composta è costituita dai seguenti elementi:\n"+it.toString());
		
		
		
	}

}
