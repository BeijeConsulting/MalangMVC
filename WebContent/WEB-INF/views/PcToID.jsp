<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PcToID</title>
</head>
<style>
#bottone{
	border-radius:5px;
	border: 1px solid black;
	padding: 5px;
	margin: 3px;
}
#conferma{
	border-radius:5px;
	border: 1px solid black;
	padding: 5px;
	margin: 3px;
}
#comp,#ut{
	border-radius:5px;
	border: 1px solid black;
	padding: 5px;
	margin: 3px;
}
form{
	color:blue;
	font-weight:bold;
}
</style>
<body>
<%

 Object utenti = request.getAttribute("utenti");
 Object computer = request.getAttribute("computer");
 out.print(utenti);
 out.print(computer);
 
%>
<b><font color='blue'>Data di Consegna:</font></b> <input type="date" id="bottone" name="datadiconsegna"><br>
<b><font color='blue'>Data di Restituzione:</font></b> <input type="date" id="bottone" name="datadirestituzione"><br>
<b><font color='blue'>Note:</font></b> <input type="text" id="bottone" name="note"><br>
<button type="submit" id="conferma" onclick="CONFERMATO!"><b><font color='blue'>CONFERMA</font></b></button><br>
</form>
<a href="Gestionale"><input type="button"></a>
<%
	Object mess = request.getAttribute("messaggio");
	out.print(mess);
%>
</body>
</html>