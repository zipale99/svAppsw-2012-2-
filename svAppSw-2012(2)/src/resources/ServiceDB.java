/**
 * 
 */
package resources;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import composite.Itinerary;

import decorator.User;
import DB.DBconnection;

/**
 * @author utente
 *
 */
public class ServiceDB {
	
	
	
	/*
	 * TO-DO: Metodo login, se l'autenticazione va a buon fine, deve restituire
	 * il ruolo dell'utente. In caso di autenticazione fallita, restituirà la stringa vuota.
	 */
	public static String login(String username, String password) throws SQLException{
		Connection conn = DBconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM UTENTI where username='"+username+"' and password='"+password+"'");
        if(rs.next()){
            return rs.getString("ruole");
        }
        rs.close();
        st.close();
        conn.close();
        return "";
	 }
	
public static ElencoAttivitaBean riempiAttDaDB() {
        
    	Connection connessione = DBconnection.getConnection();
    	
    	ElencoAttivitaBean elencoAttivita = new ElencoAttivitaBean();
    	//se la connessione è andata a buon fine   	
        try {
            Statement st = connessione.createStatement();

            String sql = "SELECT * FROM attivita";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	elencoAttivita.aggiungi(rs.getInt("id"),rs.getString("tipo"),rs.getString("citta"),rs.getString("descrizione"),rs.getInt("durata"),rs.getFloat("prezzo"));
            }
            
            st.close();
            connessione.close();
                        
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return elencoAttivita;
    }
    
    /**
     * @param elenco per gli itinerari
     */
    
    public static ArrayList<Itinerary> riempiItDaDB(User user) {
        
    	Connection connessione = DBconnection.getConnection();
    	
    	ArrayList <Itinerary> listaIt = new ArrayList<Itinerary>();
    	
    	//se la connessione è andata a buon fine   	
        try {
            Statement st = connessione.createStatement();

            String sql = "SELECT * FROM itinerario where creatoruser='"+user+"'";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	Itinerary it = new Itinerary(rs.getString("creatoruser"),
            			rs.getString("startloc"),rs.getString("endloc"),rs.getInt("durata"),
            			rs.getString("itname"),rs.getString("itdesc"),rs.getString("categoria"),rs.getString("stato"),
            			rs.getDouble("prezzo"));
            	it.setId(rs.getInt("iditinerario"));
            	listaIt.add(it);
            }
            
            st.close();
            connessione.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return listaIt;
    }
    
    
    /**
     * @param elenco per gli itinerari
     */
    
    public static ArrayList<Itinerary> searchItinerary() {
        
    	Connection connessione = DBconnection.getConnection();
    	
    	ArrayList <Itinerary> listaIt = new ArrayList<Itinerary>();
    	
    	//se la connessione è andata a buon fine   	
        try {
            Statement st = connessione.createStatement();

            String sql = "SELECT * FROM itinerario";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
            	Itinerary it = new Itinerary(rs.getString("creatoruser"),
            			rs.getString("startloc"),rs.getString("endloc"),rs.getInt("durata"),
            			rs.getString("itname"),rs.getString("itdesc"),rs.getString("categoria"),rs.getString("stato"),
            			rs.getDouble("prezzo"));
            	it.setId(rs.getInt("iditinerario"));
            	listaIt.add(it);
            }
            
            st.close();
            connessione.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return listaIt;
    }
    
    
    /**
     * @param elenco per gli itinerari
     */
    
    /*
    public static ElencoItineraryBean riempiStDaDB(String startLoc,String endLoc) {
        
    	Connection connessione = DBconnection.getConnection();
    	
    	ElencoStayItinerary elencoStayTemplate = new ElencoStayTemplateBean();
    	//se la connessione è andata a buon fine   	
        try {
            Statement st = connessione.createStatement();

            String sql = "SELECT * FROM staytemplate where startloc='"+startLoc+"' and endloc='"+endLoc+"'";

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
      
            	elencoStayTemplate.aggiungi(rs.getInt("iditinerario"),rs.getString("creatoruser"),rs.getString("startloc"),rs.getString("endloc"),rs.getInt("durata"),rs.getString("itname"),rs.getString("itdesc"),rs.getString("stato"),rs.getDouble("prezzo"));                 
            }
            
            st.close();
            connessione.close();
        }
        catch (SQLException ex) {
        	ex.printStackTrace();
        }
        return elencoItinerari;
    }
    */
	
	
}
