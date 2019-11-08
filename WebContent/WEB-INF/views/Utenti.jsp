<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crea Utente</title>
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
<b><font color='blue'>Nome:</font></b> <input type="text" id="bottone" name="nome"><br>
<b><font color='blue'>Cognome:</font></b> <input type="text" id="bottone" name="cognome"><br>
<b><font color='blue'>Email:</font></b> <input type="text" id="bottone" name="email"><br>
<button type="submit" id="conferma"><b><font color='blue'>CONFERMA</font></b></button><br>
</form>
</body>
</html>