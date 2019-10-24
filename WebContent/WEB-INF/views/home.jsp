<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.beije.controller.Utente"%>
<jsp:useBean id="user" class="it.beije.controller.Utente" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn Bean</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BeijeConsulting</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="login2.jsp">Log In</a></li>
    </ul>
  </div>
</nav>
<center>
<%String error = (String) request.getSession().getAttribute("error");
if (error != null) {
	out.print(error + "<br><br>");
	request.getSession().removeAttribute("error");
}
%>
<%
String cognome = user.getCognome() != null ? user.getCognome() : "";
String nome = user.getNome() != null ? user.getNome() : "";
String email = user.getEmail() != null ? user.getEmail() : "";
String telefono = user.getTelefono() != null ? user.getTelefono() : "";
%>

<form action="home" method="post">
	COGNOME : <input type="text" name="param_cognome" value="<%= cognome %>"><br>
	NOME : <input type="text" name="param_nome" value="<%= nome %>"><br>
	EMAIL : <input type="text" name="param_email" value="<%= email %>"><br>
	TELEFONO : <input type="text" name="param_telefono" value="<%= telefono %>"><br>
	<input type="submit" value="ACCEDI">
</form>
</center>
</body>
</html>