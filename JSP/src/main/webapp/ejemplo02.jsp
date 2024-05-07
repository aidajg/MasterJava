<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
for(int i = 0; i < 10; i++){
	out.println("<p>"+i+"</p>");
}%>

<h2>También puedo hacer esto:</h2>

<%
for(int i = 0; i < 10; i++){%>
	<p> <%=i%></p>
<%} %>


<%
for(int i = 0; i < 10; i++){%>
	<h3<%=i%>>Bienvenido a mi sitio<h3<%=i%>>
<%}%>

</body>
</html>