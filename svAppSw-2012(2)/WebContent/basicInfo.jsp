<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="composite.*"%>
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
			<h3>Inserisci le informazioni di base dell'itinerario</h3>
			<form action="Controller" method="POST">
			Nome:<br>
			<input type="text" name="nome"/>
			<br> Descrizione: <br>
			<input type="text" name="descrizione"/>
			<br>Categoria:<br>
			<input type="text" name="categoria"/>
			<input type="hidden" name="operazione" value="confermaBasicInfo">
			<br><br><input type="submit" name="conferma" value="ConfermaBasicInfo">
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