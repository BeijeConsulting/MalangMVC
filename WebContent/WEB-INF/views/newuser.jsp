<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="user" class="it.beije.controller.bean.Utente" scope="session" />
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRAZIONE</title>
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
      <li class="active"><a href="newuser">UTENTE</a></li>
    </ul>
  </div>
</nav>
<center>
<%String cognome = user.getCognome() != null ? user.getCognome() : "";
String nome = user.getNome() != null ? user.getNome() : "";
String email = user.getEmail() != null ? user.getEmail() : ""; %>
REGISTRA UTENTE: <br>
<form action="newuser" method="post">
	COGNOME : <input type="text" name="param_cognome" value="<%= cognome %>"><br>
	NOME : <input type="text" name="param_nome" value="<%= nome %>"><br>
	EMAIL : <input type="text" name="param_email" value="<%= email %>"><br>
	<input type="submit" value="INVIA">
</form>
</center>
</body>
</html>