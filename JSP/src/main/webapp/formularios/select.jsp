<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select JSP</title>
</head>
<body>

<form action="bucleRequest.jsp" method="post">
<p>Elige una opción</p>
<select name="numero">
<%
for(int i = 1; i < 6; i++){%>
	<option value="<%=i%>" name="option"><%=i%></option>
<%} %>
</select>
<input type="submit" value="Elegir">
</form>

</body>
</html>