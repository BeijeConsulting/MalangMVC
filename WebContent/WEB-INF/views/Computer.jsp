<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Computer</title>
</head>
<body>
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
<b><font color='blue'>Modello:</font></b> <input type="text" id="bottone" name="modello"><br>
<b><font color='blue'>Marca:</font></b> <input type="text" id="bottone" name="marca"><br>
<b><font color='blue'>CPU:</font></b> <input type="text" id="bottone" name="cpu"><br>
<b><font color='blue'>RAM:</font></b> <input type="text" id="bottone" name="ram"><br>
<b><font color='blue'>HD:</font></b> <input type="text" id="bottone" name="hd"><br>
<b><font color='blue'>Serial Number:</font></b> <input type="text" id="bottone" name="serial number"><br>
<b><font color='blue'>Note:</font></b> <input type="text" id="bottone" name="note"><br>
<b><font color='blue'>SO:</font></b> <input type="text" id="bottone" name="so"><br>
<button type="submit" id="conferma" onclick="CONFERMATO!"><b><font color='blue'>CONFERMA</font></b></button><br>
</form>
</body>
</html>