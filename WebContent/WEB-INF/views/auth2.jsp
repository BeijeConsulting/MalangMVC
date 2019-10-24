<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beije Consulting</title>
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
      <li class="active"><a href="auth2.jsp">CONFERMA</a></li>
    </ul>
  </div>
</nav>
<center>

<jsp:useBean id="user" class="it.beije.controller.Utente" scope="session" />
<jsp:setProperty name="user" property="cognome" param="param_cognome"/>
<jsp:setProperty name="user" property="nome" param="param_nome"/>
<jsp:setProperty name="user" property="email" param="param_email"/>
<jsp:setProperty name="user" property="telefono" param="param_telefono"/>

<form action="CSVServlet" method="post">
COGNOME: <jsp:getProperty name="user" property="cognome"/><br>
NOME: <jsp:getProperty name="user" property="nome"/><br>
EMAIL: <jsp:getProperty name="user" property="email"/><br>
TELEFONO: <jsp:getProperty name="user" property="telefono"/><br>
<br><br>
<input type="submit" value="REGISTRA CSV"><br><br>
</form>

<form action="DBServlet" method="post">
<input type="submit" value="REGISTRA DB"><br><br>
</form>

<form action="XMLServlet" method="post">
<input type="submit" value="REGISTRA XML"><br><br>
</form>
<form action="home" method="get">
<input type="submit" value="MODIFICA"><br><br>
</form>
</center>
</body>
</html>