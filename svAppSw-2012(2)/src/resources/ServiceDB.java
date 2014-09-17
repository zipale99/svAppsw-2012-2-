/**
 * 
 */
package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	
}
