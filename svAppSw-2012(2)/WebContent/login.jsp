<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "decorator.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="JavaScript">
function verificaLogin(modulo) { //Funzione per verificare che l'utente abbia inserito nome e pswd
	if (modulo.user.value == "") {
		alert("Campo User mancante.\nModulo non spedito.");
		modulo.nome.focus();
		return false;
	}
	if (modulo.password.value == "") {
		alert("Campo Password mancante.\nModulo non spedito.");
		modulo.password.focus();
		return false;
	}
	return true;
}
</script>
</head>
<!-- Se l'utente non è in sessione utente vuol dire che non è ancora loggato quindi
	visualizziamo il corpo del form, per permettergli il login.
 -->
<% 
ProxyUser p = (ProxyUser)session.getAttribute("proxy");
	if (p == null) {
%>
<body>
<form action="Controller" name="dati" onSubmit="return verificaLogin(this);" method="POST" >

Nome:
<br> <input type="text" name="user" size="30">
<br> Password: <br>
 <input type="password" name="password" size="30">

<input type="hidden" name="operazione" value="login">
<br>
<input type="submit" value="Login">
</form>


<% } //Altrimenti visualizziamo al posto del modulo per il login la scritto di benvenuto con il nome
	//recuperato da sessione utente
	else {
		String user = p.getUsername();
		String ruolo = p.getRuolo();
%>

<h4> Benvenuto/a <%=user%> (<a href="Controller?operazione=logout">Logout</a>)</h4>


<% } %>
	
</body>
</html>
