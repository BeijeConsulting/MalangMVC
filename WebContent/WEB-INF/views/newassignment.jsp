<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="assignment" class="it.beije.controller.bean.Assignment" scope="session" />
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
      <li class="active"><a href="newassignment">CONSEGNA PC</a></li>
    </ul>
  </div>
</nav>
<center>
ASSEGNA PC: <br>
<form action="newassignment" method="post">
	DATA CONSEGNA : <input type="date" name="param_consegna" value=""><br>
	DATA RESTITUZIONE : <input type="date" name="param_restituzione" value=""><br>
	NOTE : <input type="text" name="param_note" value=""><br>
	ID UTENTE : <input type="text" name="param_idutente" value=""><br>
	ID COMPUTER : <input type="text" name="param_idcomputer" value=""><br>
	<input type="submit" value="INVIA">
</form>
</center>
</body>
</html>>