<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
REGISTRA UTENTE: <br>
<form action="newuser" method="get">
	<input type="submit" value="FORM UTENTE">
</form>
REGISTRA COMPUTER: <br>
<form action="newcomputer" method="get">
	<input type="submit" value="FORM COMPUTER">
</form>
</form>
ASSEGNA COMPUTER: <br>
<form action="newassignment" method="get">
	<input type="submit" value="ASSEGNA">
</form>
LE ASSEGNAZIONI:<br>
<form action="computerdot" method="get">
	<input type="submit" value="MOSTRA">
</form>
STORICO COMPUTER:<br>
<form action="storico" method="get">
	<input type="submit" value="MOSTRA">
</form> <br><br><br><br>
<form action="allpc" method="get">
	<input type="submit" value="ALL PC">
</form> <br>
<form action="alluser" method="get">
	<input type="submit" value="ALL USER">
</form>
</center>
</body>
</html>