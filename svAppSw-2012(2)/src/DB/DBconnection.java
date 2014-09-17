package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.sql.ResultSet;
//import java.sql.PreparedStatement;


public class DBconnection {
/**
 * Restituisce la connessione JDBC al database
 * @author Sergio
 */

  public static Connection getConnection() {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");//.newInstance();
    }
        /*catch(InstantiationException e) {
        	e.printStackTrace();
        }
        
        catch(IllegalAccessException e) {
        	e.printStackTrace();
        }*/
        
    catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }

    String dburl = "jdbc:derby://localhost:1527/AgenziaAJ";

    Connection conn = null ;
        
    try {
      conn = DriverManager.getConnection(dburl);
    } 
    catch (SQLException ex) {
      ex.printStackTrace();
    }
        
    return conn ;
  }
}


