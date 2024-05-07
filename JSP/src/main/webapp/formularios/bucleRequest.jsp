<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recoger valor Select</title>
</head>
<body>

<%
String option = request.getParameter("option");
%>

<p>Has elegido la opción <%=option %></p>
</body>
</html>