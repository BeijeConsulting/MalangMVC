<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List"
	import="it.beije.controller.bean.Utente"
	import="it.beije.controller.bean.Computer"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign PC</title>
</head>
<body>
<%
	List<Utente> utenti=(List<Utente>)request.getSession().getAttribute("user");
	List<Computer> pcs=(List<Computer>)request.getSession().getAttribute("computerlist");
%>
<form method="post" action="assignpc">
<select name="idUtente">
<%
	for (Utente u: utenti){
%>
	<option value="<%=u.getId()%>"><%=u.getNome()+" "+u.getCognome()%></option>
<%
	}
%>
</select>
<select name="idComputer">
<%
	for (Computer c:pcs){
%>
	<option value="<%=c.getId()%>"><%=c.toString()%></option>
<%
	}
%>
</select><br>
Data Consegna:<br>
<input type="text" name="dataConsegna"><br>
Data Restituzione:<br>
<input type="text" name="dataRestituzione"><br>
Note:
<input type="text" name="note"><br>
<input type="submit" value="ok">
</form>
</body>
</html>