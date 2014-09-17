<%@page import="resources.*"%>
<jsp:useBean id="elencoAttivita"
             class="resources.ElencoAttivitaBean"
             scope="session" />

<!DOCTYPE html>
<html>
    <head>
        <title>Attivita</title>
        
    </head>

    <body>

        	<h1>Attivita</h1>
				
				<table>
	            <%

            		int pos=0;
                	for (Activity a : elencoAttivita.getElencoAttivita()) {               		
                		// link per le azioni                    		
        	            out.print("<tr><th>TIPO</th><td><B>"+a.getType()+"</B>");
                        out.print("</td><td><a href=\"Controller?operaz=eliminaAt&pos="+pos+
                        			"\"onclick='return del()'>elimina</a></td></tr>");                  
                    	out.print("<tr><th>CITTA</th><td><B>"+a.getLocation()+"</B>");
        	            out.print("</td></tr>");
        	            out.print("<tr><th>DESCRIZIONE</th><td><B>"+a.getDesc()+"</B>");
        	            out.print("</td></tr>");
        	            out.print("<tr><th>DURATA</th><td><B>"+a.getDurata()+"</B>");
    	                out.print("</td></tr>");
    	                out.print("<tr><th>PREZZO</th><td><B>"+a.getPrice()+"</B>");
    	                out.print("</td></tr>");
    	                out.print("<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>");
                    
                    	pos++;                    		        	            
                	}

            	%>
    		</table>

	</body>
</html>
