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
<title>Homepage</title>
</head>
<body>
Scegli Utente:
<p>
<form method="post" action="homepage">
<select name="user">
<%
	List<Utente> utenti=(List<Utente>)request.getSession().getAttribute("user");
	for (Utente u:utenti){
%>
	<option value="<%=u.getId()+" "+u.getNome()+" "+u.getCognome()+" "+u.getEmail()%>"><%=u.getNome()+" "+u.getCognome()+" "+u.getEmail()%></option>
<%
	}
%>
</select>
<input type="submit" value="ok">
</form>
<p>
<%
	List<Computer> pcs;
	if ((pcs=(List<Computer>)request.getSession().getAttribute("computerlist"))!=null){
		for (Computer c:pcs){
			out.print(c.toString()+'\n');
		}
	}
%>
<form method="get">
<input type="submit" value="Inserisci un Nuovo utente" formaction="newuser">
<input type="submit" value="Inserisci un nuovo pc" formaction="newpc">
<input type="submit" value="Assegnazione pc" formaction="assignpc">
</form>
<p>
${result}

</body>
</html>