<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="it.beije.controller.bean.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<%
	Utente user=(Utente)request.getSession().getAttribute("user");
	String nome,cognome,email,telefono;
	nome=cognome=email=telefono="";
	
	if (user!=null){
		nome=user.getNome();
		cognome=user.getCognome();
		telefono=user.getTelefono();
		email=user.getEmail();
	}

%>

<form method="post" action="auth">
Nome:<br>
<input type="text" name="nome" value="<%=nome%>"><br>
Cognome:<br>
<input type="text" name="cognome" value="<%=cognome%>"><br>
Email:<br>
<input type="text" name="email" value="<%=email%>"><br>
Telefono:<br>
<input type="text" name="telefono" value="<%= telefono%>"><br>
<input type="submit" value="invia">
</form>

</body>
</html>