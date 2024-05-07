<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recoger valores</title>
</head>
<body>

<%
String codigo = request.getParameter("codigo");
String uds = request.getParameter("uds");

%>
<p>Has comprado <%=uds%> uds. del producto con codigo <strong><%=codigo%></strong> </p>

</body>
</html>