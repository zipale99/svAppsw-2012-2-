<%@page import="resources.*"%>
<%@page import="decorator.*"%>
<%@page import="composite.Itinerary"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Itinerari</title>
        
    </head>

    <body>

        	<h1>Itinerari</h1>
				
				<table>
	            <%
	            ProxyUser pu = (ProxyUser)session.getAttribute("proxy");

            		int pos=0;
                	for (Itinerary it : pu.getUser().getItineraryList()) {               		
                		// link per le azioni                    		
        	            out.print("<tr><th>USER</th><td><B>"+it.getUser()+"</B>");
                        out.print("</td><td><a href=\"Controller?operaz=eliminaIt&pos="+pos+
                        			"\"onclick='return del()'>elimina</a></td></tr>");                  
                    	out.print("<tr><th>CITTA DI PARTENZA</th><td><B>"+it.getStartLoc()+"</B>");
        	            out.print("</td></tr>");
        	            out.print("<tr><th>CITTA DI ARRIVO</th><td><B>"+it.getEndLoc()+"</B>");
        	            out.print("</td></tr>");
        	            out.print("<tr><th>DURATA</th><td><B>"+it.getDurata()+"</B>");
    	                out.print("</td></tr>");
    	                out.print("<tr><th>NOME ITINERARIO</th><td><B>"+it.getNome()+"</B>");
    	                out.print("</td></tr>");
    	                out.print("<tr><th>DESCRIZIONE</th><td><B>"+it.getDesc()+"</B>");
    	                out.print("</td></tr>");
    	                out.print("<tr><th>STATO</th><td><B>"+it.getStato()+"</B>");
    	                out.print("</td></tr>");
    	                out.print("<tr><th>PREZZO</th><td><B>"+it.getPrice()+"</B>");
    	                out.print("</td></tr>");
    	                out.print("<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>");
                    
                    	pos++;                    		        	            
                	}
                	
                	
            	%>
    		</table>

	</body>
</html>
