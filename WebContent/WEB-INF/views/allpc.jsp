<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:forEach items="${pc}" var="temp">
	<tr><td>ID: ${temp.id_computer }</td></tr>
    <tr><td>Modello: ${temp.modello }</td></tr>
	<tr><td>Marca: ${temp.marca }</td></tr>
	<tr><td>CPU: ${temp.cpu }</td></tr>
	<tr><td>RAM: ${temp.ram }</td></tr>
	<tr><td>HD: ${temp._HD}</td></tr>
	<tr><td>S/N: ${temp._SN }</td></tr>
	<tr><td>Note: ${temp.note }</td></tr>
	<tr><td>S.O: ${temp._SO }</td></tr>
    <tr><td>---------------------------</td></tr>
</c:forEach>
</table>
</center>
</body>
</html>