<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Specifiche pc:
<form method="post" action="addpc">
<input type="text" name="serialNumber">
<input type="submit" value="OK">
</form>
<p>
<%
	if (request.getSession().getAttribute("result")=="newpc")
	{
		String sn=request.getParameter("sn");
%>
		<form method="post" action="registerpc">
		<input type="hidden" name="serialNumber" value="<%=sn%>">
		<input type="text" name="modello" placeholder="modello"><br>
		<input type="text" name="marca" placeholder="marca"><br>
		<input type="text" name="cpu" placeholder="cpu"><br>
		<input type="text" name="hd" placeholder="hd"><br>
		<input type="text" name="so" placeholder="S.O"><br>
		<input type="number" name="ram" placeholder="ram"><br>
		<input type="submit" value="Invia">
		</form>
<%
	}
	else if (request.getSession().getAttribute("result")=="oldpc"){
		out.print("L'utente possiede gia questo pc!");
	}
%>

${result}
</body>
</html>