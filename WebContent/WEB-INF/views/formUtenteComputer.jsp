<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORM UTENTE_COMPUTER</title>
</head>
<h1 style="text-align:center;">REGISTRAZIONE UTENTE_COMPUTER</h1>
<body>

<form action="formUtenteComputer" method="post">
	ID UTENTE	<input type="number" name="id_utente" value=""><br><br>
	ID COMPUTER	<input type="number" name="id_computer" value=""><br><br>
	DATA CONSEGNA  	<input type="date" name="data_consegna" value=""><br><br>
	DATA RESTITUIZIONE 	<input type="date" name="data_restituizione" value=""><br><br>
	NOTE <input type="text" name="note" value=""><br><br>
	
	<input type="submit" value="INVIA">
</form> 
</body>
</html>