package controller;

import resources.*;

public class SearchController {

	/**
	 * riempie un ArrayList contenente tutte le attivita presenti nel DB
	 */
	public static ElencoAttivitaBean cercaAttivita(){		
		return ServiceDB.riempiAttDaDB();
	}
	
	/**
	 * riempie un ArrayList contenente tutti gli itinerari presenti nel DB aventi startLoc ed endLoc
	 * @param startLoc
	 * @param endLoc
	 * @return
	 */
	public static ElencoItineraryBean cercaItinerari(String startLoc,String endLoc) {
		return ServiceDB.riempiItDaDB(startLoc,endLoc);
	}
	
	/**
	 * riempie un ArrayList contenente tutti gli stayTemplate presenti nel DB aventi startLoc ed endLoc
	 * @param startLoc
	 * @param endLoc
	 * @return
	 */
	/*
	public static ElencoItineraryBean cercaStayTemplate(String startLoc,String endLoc) {
		return ServiceDB.riempiStDaDB(startLoc,endLoc);
	}
	*/
	
}
