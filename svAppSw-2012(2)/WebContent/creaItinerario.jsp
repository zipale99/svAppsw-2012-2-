<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="composite.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="itinerario" class="composite.Itinerary" scope="session"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ManageItineraryBase</title>
<link rel="stylesheet" type="text/css" href="stile.css"/>
</head>
<body>

	<div class = "container">
	<div class = "header">
		<h1>Awesome Journey</h1>
	</div>	
	
	<div class = "main">
		<div class = "content">
			<h3>Create Itinerary</h3>
			
			<p><b>Creatore:</b> <%= itinerario.getUser() %> </p>
			<p><b>Nome:</b> <%= itinerario.getNome() %> </p>
			<p><b>Descrizione:</b> <%= itinerario.getDesc() %> </p>
			<p><b>Categoria:</b> <%= itinerario.getCategoria() %> </p>

<%
int size = itinerario.getSize();
if (size != 0) {
%>			
			
			<table>
				<tr>
					<th>Tappa</th>
					<th>Gestione Tappa</th>
				</tr>
<%

	int i = 0;
	while(size > 0) {
%>
	
				<tr>
					<td> <%= itinerario.getStayTemplate(i) %> </td>
					<td>  
						<button onclick="location.href='Controller?operazione=configureStayParameter&idTappa=<%= i %>'">ConfigureStayParameter</button> 
							<form action="Controller" method="POST" >
								<input type="hidden" name="operazione" value="deleteStay">
								<input type="hidden" name="idTappa" value='<%= i %>'>
								<input type="submit" value="Elimina" onClick="return(confirm('Sei sicuro di voler procedere?'))"/>
							</form>
					</td>
				</tr>
<%
	size--;
	i++;
	}

}
%>	
	
			</table>	
			
			
				<form action="Controller" method="POST" >
					<input type="hidden" name="operazione" value="addItineraryStay">
					<input type="submit" value="Aggiungi Tappa"/>
				</form>
				
				<br>
		
				<form action="Controller" method="POST" >
					<input type="hidden" name="operazione" value="saveItinerary">
					<input type="submit" value="Salva Itinerario"/>
				</form>
			
			
			
			
		</div>
		
		<div class = "sidenav">
			<jsp:include page="barraLaterale.jsp"></jsp:include>			
		</div>	
		
	</div>
	
	<div class = "footer">
		Progetto di Teconologie Web di Lanciano Alessandro
	</div>
	
</div>
</body>
</html>