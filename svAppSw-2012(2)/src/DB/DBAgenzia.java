package DB;

import java.sql.*;


public class DBAgenzia {
		
	public static void main(String[] args) {
	       
		Connection conn = DBconnection.getConnection();
		
	    try {
	    	
	      	//CREA TABELLA UTENTI
	        String create = "CREATE TABLE utenti("+
	         				"username VARCHAR(30),"+
	         				"password VARCHAR(30),"+
	         				"ruolo VARCHAR(30),"+  
	         			
	         				"PRIMARY KEY (username))";
	         	
	         PreparedStatement pst = conn.prepareStatement(create);
	         pst.executeUpdate();//fine creazione
	 	    	
	 	    	
	 	    	
	 	    	
	 	    	         
	             //CREA TABELLA ITINERARIO
	 	        	create = "CREATE TABLE itinerario("+
	 	        			"idItinerario INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	 	        			"creatorUser VARCHAR(30) NOT NULL,"+
	 	        			"startLoc VARCHAR(30),"+  
	 	        			"endLoc VARCHAR(30),"+
	 	        			"durata int not null,"+
	 	        			"itName VARCHAR(30),"+
	 	        			"itDesc VARCHAR(30),"+
	 	        			"stato VARCHAR(30),"+
	 	        			"prezzo float(10) not null,"+
	 					
	 						"PRIMARY KEY (idItinerario),"+
	 						"FOREIGN KEY (creatorUser) REFERENCES UTENTI (username))";
	 	        	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 	    	



	        
	             //CREA TABELLA STAYTEMPLATE
	 	        	create = "CREATE TABLE STAYTEMPLATE("+
	 	        			"idStayTempl INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+	 	    			
	 	        			"nomeST varchar (30),"+
	 	        			"startLoc varchar (30),"+
	 	        			"endLoc varchar (30),"+
	 	        			"durata integer not null,"+
	 	        			"transport boolean not null,"+
	 	        			"prezzo float(10) not null,"+
	 	        			
	 	    				"PRIMARY KEY (idStayTempl))";
	 	        	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 	                	
	 	        
	 	                
	 	                	                
	 	        	
	 	              //CREA TABELLA ATTIVITA_ST che visualizza le attività prestabilite dalla AJ
	 	        	create = "CREATE TABLE ATTIVITA_ST("+
	 	    	    		 "idAttivitaST INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	 	    	    		 "idStayTemplate INTEGER NOT NULL,"+	 	    	    		 	
	 	    	    		 "idActivity integer,"+
	 	    	    		 "obbligatoria boolean not null,"+
	 	    	    		 "timeOffset integer not null,"+
	     						
	 	    	    		"PRIMARY KEY (idAttivitaST),"+
	 	    	    		"FOREIGN KEY (idStayTemplate) REFERENCES STAYTEMPLATE (idStayTempl))";

	         	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 	                
	 	    	        
	 	    	        
	 		        	
	 		        	
	 		              //CREA TABELLA leaf
	 	        	create ="CREATE TABLE STAYTEMPLATE_LEAF("+
	 	        			"idSTLeaf INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	 		    	 		"idStayTemplate integer,"+
	 		    	 		"startLoc varchar(30),"+
	 		     		    "endLoc varchar(30),"+
	 		    	 		"typeLeaf varchar(30),"+
	 		    	   	    "durata VARCHAR(30),"+
	 		    		    "transport varchar(30),"+
	 		    	   	    "accomodation varchar(30),"+
	 		    	    		        
	 		     		    "PRIMARY KEY (idSTLeaf),"+
	 		    	    	"FOREIGN KEY (idStayTemplate) REFERENCES STAYTEMPLATE (idStayTempl))";
	     	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 	    	    
	 	    	        
	 	            
	 	        	

	 	        	
	 	        //CREA TABELLA stay, dove vengono personalizzati i template dall'utente(con attività e opt)
	 	        //tale tabella serve a tenere i riferimenti ai leaf(staytemplateLeaf) i quali avranno la
	 	        //voluta personalizzazione nella tabella activity_stay e opzioni_pers
	 	        	create ="CREATE TABLE stay("+
	 	        			"idStay INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	 		    	 		"idItinerario integer not null"+
	 	        			"idStayTemplate integer not null,"+
	 		    	   	    "timeOffsea<t integer not null,"+
	 	        			"prezzo float(10) not null,"+
	 		    	    		        
	 		     		    "PRIMARY KEY (idStay),"+
	 		     		    "FOREIGN KEY (idItinerario) REFERENCES Itinerario(idItinerario),"+
	 		    	    	"FOREIGN KEY (idStayTemplate) REFERENCES STAYTEMPLATE (idStayTempl))";
	     	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 	        	
	 	        	
	 	        		 	        		 	       
	 	
	        	
	        	
	              //CREA TABELLA attivita
	 	        	create = "CREATE TABLE ATTIVITA("+
	 		    	   		 "idAttivita INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	 		    	   		 "tipo varchar(30),"+
	 		    	   		 "citta varchar(30),"+
	 		    	   		 "descrizione varchar(30),"+
	 		    	   		 "durata varchar(30),"+
	 		    	   		 "prezzo float(10) not null,"+
	 		    	
	 		    	   		 "PRIMARY KEY (idAttivita))";

	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 	    		 	    	
	 		    	 
	 	        	     
	 					        	
	 	        	
	 	        	
	        			//crea teballa che elenca le opzioni possibili per l'utente
	 	        	create = "CREATE TABLE OPTION_LIST("+
				   		 "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
				   		 "idOption integer not null,"+
				  		 "description varchar(50),"+
				  		 "value varchar(50),"+
				  		 "price float(10) not null,"+
	
 						"PRIMARY key (id))";

				    	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 	        	
	 	        	
	 	        	
	        	
	 	        	
	 					        	
 					          //CREA TABELLA opzioni standard, prestabilite dall'agenzia per i singoli leaf
	 	        	create = "CREATE TABLE opzioni_Standard ("+
	 			      		 "idOption INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	 			      		 "OptionName varchar(30),"+
	 			      		 "idSTLeaf integer not null,"+
	 			      		 "idOptionList integer not null,"+

	    					"PRIMARY KEY (idOption),"+
	    					"foreign key(idSTLeaf) references staytemplate_LEAF(idSTLeaf),"+
	    					"foreign key(idOptionList) references OPTION_LIST(id))";
	 			    	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 				    	       
	 				    	        
	 				    	        
	 				    	        
 				        	
					              //CREA TABELLA opzioni personalizzate dall'utente
	 	        	create = "CREATE TABLE OPZIONI_PERS("+
	 				   		 "idOption INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	 				  		 "idOptStandard integer not null,"+
	 				  		 "idOptionList integer not null,"+
	 	
	     					"PRIMARY key (idOption),"+
	     					"foreign key(idOptStandard) references opzioni_standard(idOption),"+
	     					"FOREIGN KEY (idOptionList) REFERENCES option_list(id))";

	 				    	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 					           
	 					    	        	 						    	        	 	        
	 	        	
	 	        	
	 						    	        
	 						        	
	 				          //CREA TABELLA viaggio
	 	        	create = "CREATE TABLE viaggio("+
	 				   		 "idViaggio INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"+
	 				   		 "creatorUser VARCHAR(30)  NOT NULL,"+	
	 				   		 "idItinerario INTEGER NOT NULL,"+
	 				   		 "startDate VARCHAR(30) NOT NULL,"+
	 				   		 "endDate VARCHAR(30) NOT NULL,"+
	 				   		 "costo float(10) not null,"+
	 				   		 "nPersone integer not null,"+
	 				   		 "acquistato varchar(20) not null,"+
	 				   		
	 				   		 "PRIMARY KEY (idViaggio),"+
	     					 "FOREIGN KEY (creatorUser) REFERENCES UTENTI (username),"+
	     			  		 "FOREIGN KEY (idItinerario) REFERENCES ITINERARIO (idItinerario))";
	 					    	
	 	        	pst = conn.prepareStatement(create);
	 	        	pst.executeUpdate();//fine creazione*/
	 		
	 	    conn.close();
	    	
	    }
	    catch(SQLException ex) {
	    	ex.printStackTrace();
	    }
	    
	    
	}
	
	
}