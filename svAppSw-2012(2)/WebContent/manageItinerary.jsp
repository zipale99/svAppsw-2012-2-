<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="decorator.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<%
DecoratorUser du = (DecoratorUser)session.getAttribute("utenteDecorato");
System.out.println("utente:  " + du.getRuolo());
if (du.getRuolo().equals("CreatorCustomer")) {
%>	
			<h3>Manage Itinerary Base</h3>
			<hr>
			<ul id="menu">
			<li><a href="basicInfo.jsp">Crea nuovo Itinerario</a></li>
   			<li><a href="Controller?operazione=modificaItinerario">Modifica Itinerario esistente</a></li>
			</ul>
<% 
	}
	else if (du.getRuolo().equals("CreatorTA")) { 
%>
	
			<h3>Manage Itinerary Pro</h3>
			<hr>
			<ul id="menu">
			<li><a href="Controller?operazione=basicInfo.jsp">Crea nuovo Itinerario</a></li>
   			<li><a href="Controller?operazione=modificaItinerario">Modifica Itinerario esistente</a></li>
			</ul>
	
<%
	}
%>
			
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