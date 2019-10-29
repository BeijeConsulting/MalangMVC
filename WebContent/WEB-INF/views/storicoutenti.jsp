<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="it.beije.controller.bean.Assignment" %>
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
<table>
<c:forEach items="${list}" var="temp">
    <tr><td>ID ASSEGNAZIONE:</td><td>${temp.idusers_computer}</td></tr>
    <tr><td>ID UTENTE:</td><td>${temp.id_utente}</td></tr>
    <tr><td>ID COMPUTER:</td><td>${temp.id_computer}</td></tr>
    <tr><td>CONSEGNA:</td><td>${temp.consegna}</td></tr>
    <tr><td>RESTITUZIONE:</td><td>${temp.restituzione}</td></tr>
    <tr><td>---------------------------</td></tr>
</c:forEach>
</table>
Computer: <br>
Modello: ${pc.modello }<br>
Marca: ${pc.marca }<br>
CPU: ${pc.cpu } <br>
RAM: ${pc.ram } <br>
HD: ${pc._HD} <br>
S/N: ${pc._SN } <br>
Note: ${pc.note } <br>
S.O: ${pc._SO }<br>
</center>
</body>
</html>