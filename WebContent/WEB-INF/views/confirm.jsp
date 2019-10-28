<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm</title>
</head>
<body>
<%=request.getSession().getAttribute("userBean").toString() %>
<p>
<form method="post" action="save">
<input type="submit" value="Ok">
<input type="submit" value="Modifica" formaction="modifica">

<% 
	String result;
	if ((result=request.getParameter("result"))!=null) 
	{
		out.print(result);
	}
%>
</form>
</body>
</html>