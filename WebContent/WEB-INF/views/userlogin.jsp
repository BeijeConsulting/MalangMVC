<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
</head>
<body>
Login<p>
<form method="post" action="userlogin">
<input type="text" name="nome" placeholder="Nome"><br>
<input type="text" name="cognome" placeholder="Cognome"><br>
<input type="text" name="email" placeholder="Email"><br>
<input type="submit" value="Invia">
<input type="submit" value="Registrati" formaction="register">
</form>
<br>
${result}
</body>
</html>