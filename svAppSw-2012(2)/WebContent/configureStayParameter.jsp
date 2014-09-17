<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="composite.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="tappa" class="composite.StayTemplateComposite" scope="session"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Stay</title>
<link rel="stylesheet" type="text/css" href="stile.css"/>
</head>
<body>

	<div class = "container">
	<div class = "header">
		<h1>Awesome Journey</h1>
	</div>	
	
	<div class = "main">
		<div class = "content">
			<h3>ConfigureStayParameter</h3>
			
Il Template selezionato è composto dalle seguenti parti. 



<%
int size = tappa.getSize();
if (size != 0) {
%>			
			
			<table>
				<tr>
					<th>StayTemplate</th>
					<th></th>
				</tr>
<%

	int i = 0;
	while(size > 0) {
%>
	
				<tr>
					<td> <%= tappa.getStayTemplate(i).toString() %> </td>
					<td>  
						<button onclick="location.href='Controller?operazione=addStayTemplate&idTappa=<%= i %>'">Aggiungi Template</button> 
							<form action="Controller" method="POST" >
								<input type="hidden" name="operazione" value="viewStayTemplate">
								<input type="hidden" name="idTappa" value='<%= i %>'>
								<input type="submit" value="Visualizza Template" onClick="return(confirm('Sei sicuro di voler procedere?'))"/>
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