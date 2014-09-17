<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="decorator.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/stile.css" media="screen"/>
<title>Barra di navigazione laterale</title>
</head>
<body>


<!-- La visualizzazione della corretta home page è gestita lato client andando
a esaminare l'oggetto session e in base al ruolo dell'utente loggato viene fatto variare il menu 
visualizzato 
-->

<%
ProxyUser p = (ProxyUser)session.getAttribute("proxy");
if(p != null) {
%>
	<jsp:include page = "login.jsp" ></jsp:include>
	<hr>
	<ul id="menu">
	<li><a href="Index.jsp">Home</a></li>
	<li><a href="Controller?operazione=searchItineraryOrJourney">SearchItineraryOrJourney</a></li>
   	<li><a href="Controller?operazione=manageItinerary">Manage Itinerary</a></li>
	</ul>
	
<% 
	}
	else { 
%>
	
	<p>Benvenuto Ospite</p>
	<hr>
	<jsp:include page = "login.jsp"></jsp:include>
	<hr>
	<ul id="menu">
	<li><a href="Index.jsp">Home</a></li>
	<li><a href="Controller?operazione=manageItinerary.jsp">SearchItineraryOrJourney</a></li>
   	</ul>
	
<%
	}
%>

	

</body>
</html>