<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:useBean id="user" class="it.beije.controller.bean.Utente" scope="session" />
    <jsp:useBean id="pc" class="it.beije.controller.bean.Computer" scope="session" />
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
%>
<table align="center">
<tr><td>Utente:</td></tr>
<tr><td>ID: </td><td>${user.idusers}</td></tr>
<tr><td>Cognome: </td><td>${user.cognome }</td></tr>
<tr><td>Nome: </td><td>${user.nome }</td></tr>
<tr><td>email: </td><td>${user.email }</td></tr>

<table align="right">
<c:forEach items="${list}" var="temp">
    <tr><td>ID ASSEGNAZIONE:</td><td>${temp.idusers_computer}</td></tr>
    <tr><td>ID UTENTE:</td><td>${temp.id_utente}</td></tr>
    <tr><td>ID COMPUTER:</td><td>${temp.id_computer}</td></tr>
    <tr><td>CONSEGNA:</td><td>${temp.consegna}</td></tr>
    <tr><td>RESTITUZIONE:</td><td>${temp.restituzione}</td></tr>
    <tr><td>---------------------------</td></tr>
</c:forEach>

<table align="left">
<c:forEach items="${pcs}" var="pc">
<tr><td>Computer:</td></tr>
<tr><td>ID: ${pc.id_computer }</td></tr>
<tr><td>Modello: ${pc.modello }</td></tr>
<tr><td>Marca: ${pc.marca }</td></tr>
<tr><td>CPU: ${pc.cpu }</td></tr>
<tr><td>RAM: ${pc.ram }</td></tr>
<tr><td>HD: ${pc._HD}</td></tr>
<tr><td>S/N: ${pc._SN }</td></tr>
<tr><td>Note: ${pc.note }</td></tr>
<tr><td>S.O: ${pc._SO }</td></tr>
<tr><td>---------------------------</td></tr>
</c:forEach>
</table>
</table>
</table>
</body>
</html>