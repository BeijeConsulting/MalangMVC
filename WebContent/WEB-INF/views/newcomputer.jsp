<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="computer" class="it.beije.controller.bean.Computer" scope="session" />
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
      <li class="active"><a href="newcomputer">COMPUTER</a></li>
    </ul>
  </div>
</nav>
<center>
REGISTRA COMPUTER: <br>
<form action="newcomputer" method="post">
	MODELLO : <input type="text" name="param_modello" value=""><br>
	MARCA : <input type="text" name="param_marca" value=""><br>
	CPU : <input type="text" name="param_cpu" value=""><br>
	RAM : <input type="text" name="param_ram" value=""><br>
	HD : <input type="text" name="param_HD" value=""><br>
	S/N : <input type="text" name="param_SN" value=""><br>
	NOTE : <input type="text" name="param_note" value=""><br>
	S.O. : <input type="text" name="param_SO" value=""><br>
	<input type="submit" value="INVIA">
</form>
</center>
</body>
</html>