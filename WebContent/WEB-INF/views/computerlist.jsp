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
      <li class="active"><a href="home">Log In</a></li>
    </ul>
  </div>
</nav>
<center>
COMPUTER IN DOTAZIONE:<br>
ID ASSEGNAZIONE: ${assignment.idusers_computer}<br>
ID UTENTE: ${assignment.id_utente}<br>
ID COMPUTER: ${assignment.id_computer}<br>
DATA CONSEGNA: ${assignment.consegna}<br>
DATA RESTITUZIONE: ${assignment.restituzione}<br><br>
</center>
</body>
</html>