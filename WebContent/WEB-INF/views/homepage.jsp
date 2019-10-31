<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<form method="get">
<input type="submit" value="Aggiungi utente" formaction="adduser">
<input type="submit" value="Aggiungi computer" formaction="addcomputer">
</form>
<p>
${risultato}
</body>
</html>