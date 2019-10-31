<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORM COMPUTER</title>
</head>
<h1 style="text-align:center;">REGISTRAZIONE COMPUTER</h1>
<body>

<form action="formComputer" method="post">
	MODELLO  <input type="text" name="modello" value=""><br><br>
	MARCA  <input type="text" name="marca" value=""><br><br>
	CPU  <input type="text" name="cpu" value=""><br><br>
	RAM  <input type="int" name="ram" value=""><br><br>
	HD  <input type="text" name="hd" value=""><br><br>
	SERIAL NUMBER <input type="text" name="serial_number" value=""><br> <br>
	NOTE  <input type="text" name="note" value=""><br><br>
	SO  <input type="text" name="so" value=""><br><br> 
	<input type="submit" value="INVIA">
</form>

</body>
</html>