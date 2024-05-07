<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validar formulario</title>
</head>
<body>
<%
String user = request.getParameter("user");
String pwd = request.getParameter("pwd");

if(user.equals("admin") && pwd.equals("123")){%>
	<p style=color:green>Usuario admitido!</p>
	<h3>Bienvenid@ <%=user%></h3><%
}else{%>
	<p style=color:red>Usuario no admitido.  (<%=user%>)</p>
<%} %>

</body>
</html>