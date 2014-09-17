<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="stile.css"/>

</head>
<body>

<div class = "container">
	<div class = "header">
		<h1>AWESOME JOURNEY</h1>
	</div>	
	
	<div class = "main">
		<div class = "content">
		<p>Benvenuto nell'agenzia viaggi Awesome Journey. Seleziona nel menu a lato l'operazione che vuoi effettuare.</p>
			<div class="contentImg">
			<img src="img/logo.jpeg">
			</div>		
		</div>
		
		<div class = "sidenav">
			<jsp:include page="barraLaterale.jsp"></jsp:include>			
		</div>	
	</div>
	
	<div class = "footer">
		Progetto di Sviluppo Applicazioni Software di Lanciano Alessandro e Ficarra Sergio
	</div>
	
</div>


</body>
</html>