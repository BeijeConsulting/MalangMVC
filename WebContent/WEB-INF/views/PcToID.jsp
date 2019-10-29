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
</style>
<body>
<form method=post>
<b><font color='blue'>Id Utente:</font></b> <input type="text" id="bottone" name="idutente"><br>
<b><font color='blue'>Id Computer:</font></b> <input type="text" id="bottone" name="idcomputer"><br>
<b><font color='blue'>Data di Consegna:</font></b> <input type="text" id="bottone" name="datadiconsegna"><br>
<b><font color='blue'>Data di Restituzione:</font></b> <input type="text" id="bottone" name="datadirestituzione"><br>
<b><font color='blue'>Note:</font></b> <input type="text" id="bottone" name="note"><br>
<button type="submit" id="conferma" onclick="CONFERMATO!"><b><font color='blue'>CONFERMA</font></b></button><br>
</form>
</body>
</html>