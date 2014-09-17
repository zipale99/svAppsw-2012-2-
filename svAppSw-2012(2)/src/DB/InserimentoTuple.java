package DB;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.*;


public class InserimentoTuple {

	public static void main(String[] args) {
		
		Connection conn = DBconnection.getConnection();
		PreparedStatement pst=null;
		String insert=null;
	    try {
		
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "culturale");
	    	pst.setString(2, "torino");
	    	pst.setString(3, "visita al museo egizio");
	    	pst.setInt(4, 2);
	    	pst.setFloat(5, 35);
	    	pst.executeUpdate();
	    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "turistica");
	    	pst.setString(2, "foggia");
	    	pst.setString(3, "visita alla cattedrale");
	    	pst.setInt(4, 2);
	    	pst.setFloat(5, 75);
	    	pst.executeUpdate();
	    		    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "turistica");
	    	pst.setString(2, "roma");
	    	pst.setString(3, "visita al colosseo");
	    	pst.setInt(4, 3);
	    	pst.setFloat(5, 45);
	    	pst.executeUpdate();
	    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "ludica");
	    	pst.setString(2, "milano");
	    	pst.setString(3, "partita dell'inter");
	    	pst.setInt(4, 2);
	    	pst.setFloat(5, 55);
	    	pst.executeUpdate();
	    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "sportiva");
	    	pst.setString(2, "firenze");
	    	pst.setString(3, "partita della fiorentina");
	    	pst.setInt(4, 2);
	    	pst.setFloat(5, 37);
	    	pst.executeUpdate();

	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "turistica");
	    	pst.setString(2, "napoli");
	    	pst.setString(3, "visita al vesuvio");
	    	pst.setInt(4, 2);
	    	pst.setFloat(5, 15);
	    	pst.executeUpdate();
	    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "turistica");
	    	pst.setString(2, "reggio-calabria");
	    	pst.setString(3, "lungo mare");
	    	pst.setInt(4, 2);
	    	pst.setFloat(5, 85);
	    	pst.executeUpdate();
	    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "culturale");
	    	pst.setString(2, "roma");
	    	pst.setString(3, "visita ai fori romani");
	    	pst.setInt(4, 2);
	    	pst.setFloat(5, 95);
	    	pst.executeUpdate();
	    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "turistica");
	    	pst.setString(2, "roma");
	    	pst.setString(3, "visita ponte sisto");
	    	pst.setInt(4, 1);
	    	pst.setFloat(5, 92);
	    	pst.executeUpdate();
	    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "turistica");
	    	pst.setString(2, "roma");
	    	pst.setString(3, "visita piazza di spagna");
	    	pst.setInt(4, 2);
	    	pst.setFloat(5, 52);
	    	pst.executeUpdate();
	    	
	    	insert = "INSERT INTO attivita (tipo,citta,descrizione,durata,prezzo)VALUES (?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "culturale");
	    	pst.setString(2, "venaria");
	    	pst.setString(3, "visita alla reggia");
	    	pst.setInt(4, 3);
	    	pst.setFloat(5, 51);
	    	pst.executeUpdate();
	    	
	    	
	    	
	    	
	    	insert = "INSERT INTO utenti (username,password,ruole)VALUES (?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "antonio");
	    	pst.setString(2, "p1");
	    	pst.setString(3, "TA");
	    	pst.executeUpdate();
	    		    	
	    	insert = "INSERT INTO utenti (username,password,ruole)VALUES (?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "lucia");
	    	pst.setString(2, "p2");
	    	pst.setString(3, "TA");
	    	pst.executeUpdate();
	    		    	
	    	insert = "INSERT INTO utenti (username,password,ruole)VALUES (?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "filomena");
	    	pst.setString(2, "p3");
	    	pst.setString(3, "customer");
 			pst.executeUpdate();
	    	
	    	
	    	
	    	
	    	insert = "INSERT INTO itinerario(creatoruser,startloc,endloc,durata,itname,itdesc,stato,prezzo)VALUES (?,?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "filomena");
	    	pst.setString(2, "torino");
	    	pst.setString(3, "roma");
	    	pst.setInt(4, 3);
	    	pst.setString(5, "to-rm");
	    	pst.setString(6, "part:8.00 arr:10.00");
	    	pst.setString(7, "completo");
	    	pst.setFloat(8, 100);
 			pst.executeUpdate();
	    	
	    	insert = "INSERT INTO itinerario(creatoruser,startloc,endloc,durata,itname,itdesc,stato,prezzo)VALUES (?,?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "antonio");
	    	pst.setString(2, "roma");
	    	pst.setString(3, "milano");
	    	pst.setInt(4, 4);
	    	pst.setString(5, "rm-mi");
	    	pst.setString(6, "part:7.00 arr:12.00");
	    	pst.setString(7, "completo");
	    	pst.setFloat(8, 100);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO itinerario(creatoruser,startloc,endloc,durata,itname,itdesc,stato,prezzo)VALUES (?,?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "lucia");
	    	pst.setString(2, "milano");
	    	pst.setString(3, "roma");
	    	pst.setInt(4, 5);
	    	pst.setString(5, "mi-rm");
	    	pst.setString(6, "part:9.00 arr:16.00");
	    	pst.setString(7, "completo");
	    	pst.setFloat(8, 100);
 			pst.executeUpdate();
	    	
 			insert = "INSERT INTO itinerario(creatoruser,startloc,endloc,durata,itname,itdesc,stato,prezzo)VALUES (?,?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "lucia");
	    	pst.setString(2, "napoli");
	    	pst.setString(3, "firenze");
	    	pst.setInt(4, 7);
	    	pst.setString(5, "na-fi");
	    	pst.setString(6, "part:8.00 arr:20.00");
	    	pst.setString(7, "completo");
	    	pst.setFloat(8, 100);
 			pst.executeUpdate();
	    	
 			insert = "INSERT INTO itinerario(creatoruser,startloc,endloc,durata,itname,itdesc,stato,prezzo)VALUES (?,?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "antonio");
	    	pst.setString(2, "roma");
	    	pst.setString(3, "reggio-calabria");
	    	pst.setInt(4, 10);
	    	pst.setString(5, "rm-rc");
	    	pst.setString(6, "part:10.00 arr:18.00");
	    	pst.setString(7, "completo");
	    	pst.setFloat(8, 100);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO itinerario(creatoruser,startloc,endloc,durata,itname,itdesc,stato,prezzo)VALUES (?,?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "antonio");
	    	pst.setString(2, "milano");
	    	pst.setString(3, "napoli");
	    	pst.setInt(4, 5);
	    	pst.setString(5, "mi-na");
	    	pst.setString(6, "part:11.00 arr:22.00");
	    	pst.setString(7, "completo");
	    	pst.setFloat(8, 100);
 			pst.executeUpdate();
 			
 			
 			
 			
	    	insert = "INSERT INTO staytemplate(nomest,startloc,endloc,durata,transport,prezzo)VALUES (?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "st1");
	      	pst.setString(2, "torino");
	    	pst.setString(3, "roma");
	    	pst.setInt(4, 2);
	    	pst.setBoolean(5, false);
	    	pst.setFloat(6, 150);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate(nomest,startloc,endloc,durata,transport,prezzo)VALUES (?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "st2");
	    	pst.setString(2, "roma");
	    	pst.setString(3, "milano");
	    	pst.setInt(4, 5);
	    	pst.setBoolean(5, false);
	    	pst.setFloat(6, 250);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate(nomest,startloc,endloc,durata,transport,prezzo)VALUES (?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            	    	
	    	pst.setString(1, "st3");
	    	pst.setString(2, "milano");
	    	pst.setString(3, "roma");
	    	pst.setInt(4, 2);
	    	pst.setBoolean(5, false);
	    	pst.setFloat(6, 150);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate(nomest,startloc,endloc,durata,transport,prezzo)VALUES (?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "st4");
	    	pst.setString(2, "napoli");
	    	pst.setString(3, "firenze");
	    	pst.setInt(4, 3);
	    	pst.setBoolean(5, false);
	    	pst.setFloat(6, 150);
 			pst.executeUpdate();
	    	
 			insert = "INSERT INTO staytemplate(nomest,startloc,endloc,durata,transport,prezzo)VALUES (?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            	    	
	    	pst.setString(1, "st5");
	    	pst.setString(2, "roma");
	    	pst.setString(3, "reggio-calabria");
	    	pst.setInt(4, 3);
	    	pst.setBoolean(5, false);
	    	pst.setFloat(6, 250);
 			pst.executeUpdate();
	    	
 			insert = "INSERT INTO staytemplate(nomest,startloc,endloc,durata,transport,prezzo)VALUES (?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setString(1, "st6");
	    	pst.setString(2, "milano");
	    	pst.setString(3, "napoli");
	    	pst.setInt(4, 3);
	    	pst.setBoolean(5, false);
	    	pst.setFloat(6, 250);
 			pst.executeUpdate();
 			
 			
 			
 			
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 1);
	    	pst.setString(2, "torino");
	    	pst.setString(3, "torino");
	    	pst.setString(4, "accomodation");
	    	pst.setInt(5, 2);
	    	pst.setString(6, null);
	    	pst.setString(7, "hotel");
 			pst.executeUpdate();
 			
	    	insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 1);
	    	pst.setString(2, "torino");
	    	pst.setString(3, "firenze");
	    	pst.setString(4, "transport");
	    	pst.setInt(5, 1);
	    	pst.setString(6,"auto");
	    	pst.setString(7, null);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 1);
	    	pst.setString(2, "firenze");
	    	pst.setString(3, "firenze");
	    	pst.setString(4, "accomodation");
	    	pst.setInt(5, 2);
	    	pst.setString(6,null);
	    	pst.setString(7, "hotel");
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 1);
	    	pst.setString(2, "firenze");
	    	pst.setString(3, "roma");
	    	pst.setString(4, "transport");
	    	pst.setInt(5, 1);
	    	pst.setString(6,"auto");
	    	pst.setString(7, null);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 5);
	    	pst.setString(2, "roma");
	    	pst.setString(3, "foggia");
	    	pst.setString(4, "transport");
	    	pst.setInt(5, 1);
	    	pst.setString(6,"auto");
	    	pst.setString(7, null);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 5);
	    	pst.setString(2, "foggia");
	    	pst.setString(3, "foggia");
	    	pst.setString(4, "accomodation");
	    	pst.setInt(5, 2);
	    	pst.setString(6,null);
	    	pst.setString(7, "notel");
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 5);
	    	pst.setString(2, "foggia");
	    	pst.setString(3, "reggio-calabria");
	    	pst.setString(4, "transport");
	    	pst.setInt(5, 1);
	    	pst.setString(6,"auto");
	    	pst.setString(7, null);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 1);
	    	pst.setString(2, "torino");
	    	pst.setString(3, "venaria");
	    	pst.setString(4, "transport");
	    	pst.setInt(5, 1);
	    	pst.setString(6,"auto");
	    	pst.setString(7, null);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 1);
	    	pst.setString(2, "venaria");
	    	pst.setString(3, "venaria");
	    	pst.setString(4, "accomodation");
	    	pst.setInt(5, 1);
	    	pst.setString(6,null);
	    	pst.setString(7, "hotel");
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 1);
	    	pst.setString(2, "venaria");
	    	pst.setString(3, "firenze");
	    	pst.setString(4, "transport");
	    	pst.setInt(5, 1);
	    	pst.setString(6,"autobus");
	    	pst.setString(7, null);
 			pst.executeUpdate();
 			
 			insert = "INSERT INTO staytemplate_leaf(idstaytemplate,startloc,endloc,typeleaf,durata,transport,accomodation)VALUES (?,?,?,?,?,?,?)";
	    	pst = conn.prepareStatement(insert);            
	    	pst.setInt(1, 6);
	    	pst.setString(2, "napoli");
	    	pst.setString(3, "napoli");
	    	pst.setString(4, "accomodation");
	    	pst.setInt(5, 1);
	    	pst.setString(6, null);
	    	pst.setString(7, "hotel");
 			pst.executeUpdate();
	    	
 			
 			
 			
 			insert ="insert into attivita_st(idstaytemplate,idactivity,obbligatoria,timeoffset) values(?,?,?,?)";
 			pst = conn.prepareStatement(insert);
 			pst.setInt(1, 1);
 			pst.setInt(2, 2);
 			pst.setBoolean(3, true);
 			pst.setInt(4, 1);
 			pst.executeUpdate();
 			
 			insert ="insert into attivita_st(idstaytemplate,idactivity,obbligatoria,timeoffset) values(?,?,?,?)";
 			pst = conn.prepareStatement(insert);
 			pst.setInt(1, 2);
 			pst.setInt(2, 3);
 			pst.setBoolean(3, true);
 			pst.setInt(4, 1);
 			pst.executeUpdate();
 			
 			
 			
 			
 			insert="INSERT INTO OPTION_LIST(idOption,description,value,price) values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1,1);
 			pst.setString(2, "aperta 8:00-22:00");
 			pst.setString(3,"si");
 			pst.setFloat(4, 120);
 			pst.executeUpdate();
 			
 			insert="INSERT INTO OPTION_LIST(idOption,description,value,price) values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1,1);
 			pst.setString(2, "aperta 8:00-22:00");
 			pst.setString(3,"no");
 			pst.setFloat(4, 0);
 			pst.executeUpdate();
 			
 			insert="INSERT INTO OPTION_LIST(idOption,description,value,price) values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1, 2);
 			pst.setString(2, "aperta 10:00-20:00");
 			pst.setString(3,"si");
 			pst.setFloat(4, 100);
 			pst.executeUpdate();
 			
 			insert="INSERT INTO OPTION_LIST(idOption,description,value,price) values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1, 2);
 			pst.setString(2, "aperta 10:00-20:00");
 			pst.setString(3,"no");
 			pst.setFloat(4, 0);
 			pst.executeUpdate();
 			
 			insert="INSERT INTO OPTION_LIST(idOption,description,value,price) values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1, 3);
 			pst.setString(2, "orario continuato");
 			pst.setString(3,"si");
 			pst.setFloat(4, 50);
 			pst.executeUpdate();
 			
 			insert="INSERT INTO OPTION_LIST(idOption,description,value,price) values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1, 3);
 			pst.setString(2, "orario continuato");
 			pst.setString(3,"no");
 			pst.setFloat(4, 0);
 			pst.executeUpdate();
 			
 			
 			
 			
 			
 			
 			insert="insert into opzioni_standard(optionName,idSTleaf,idOptionList)values(?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setString(1, "piscina");
 			pst.setInt(2, 3);
 			pst.setInt(3, 1);
 			pst.executeUpdate();
 			
 			insert="insert into opzioni_standard(optionName,idSTleaf,idOptionList)values(?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setString(1, "piscina");
 			pst.setInt(2, 2);
 			pst.setInt(3, 2);
 			pst.executeUpdate();
 			
 			insert="insert into opzioni_standard(optionName,idSTleaf,idOptionList)values(?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setString(1, "piscina");
 			pst.setInt(2, 11);
 			pst.setInt(3, 1);
 			pst.executeUpdate();
 			
 			
 			
 			
 			insert="insert into viaggio(creatoruser,iditinerario,startDate,endDate,costo,npersone,acquistato)values(?,?,?,?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setString(1, "filomena");
 			pst.setInt(2, 1);
 			pst.setString(3, "08-agosto-2014");
 			pst.setString(4, "15-agosto-2014");
 			pst.setFloat(5, 100);
 			pst.setInt(6, 3);
 			pst.setString(7, "si");
 			pst.executeUpdate();
 			
 			insert="insert into viaggio(creatoruser,iditinerario,startDate,endDate,costo,npersone,acquistato)values(?,?,?,?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setString(1, "antonio");
 			pst.setInt(2, 2);
 			pst.setString(3, "03-agosto-2014");
 			pst.setString(4, "25-agosto-2014");
 			pst.setFloat(5, 100);
 			pst.setInt(6, 3);
 			pst.setString(7, "no");
 			pst.executeUpdate();
 			
 			
 			
 			
 			insert="insert into attivita_st(idstaytemplate,idactivity,obbligatoria,timeoffset)values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1, 1);
 			pst.setInt(2, 1);
 			pst.setBoolean(3, true);
 			pst.setInt(4, 1);
 			pst.executeUpdate();
 			
 			insert="insert into attivita_st(idstaytemplate,idactivity,obbligatoria,timeoffset)values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1, 2);
 			pst.setInt(2, 1);
 			pst.setBoolean(3, true);
 			pst.setInt(4, 1);
 			pst.executeUpdate();
 			
 			insert="insert into attivita_st(idstaytemplate,idactivity,obbligatoria,timeoffset)values(?,?,?,?)";
 			pst=conn.prepareStatement(insert);
 			pst.setInt(1, 3);
 			pst.setInt(2, 1);
 			pst.setBoolean(3, true);
 			pst.setInt(4, 1);
 			pst.executeUpdate();
 			
	    }
	    
	    catch (SQLException ex) {
		  	ex.printStackTrace();
		}
	    	
		
		

	}

}
