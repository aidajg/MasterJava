<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Error login </title>
	</head>
	<body>
		<%
		String usuario = request.getParameter("usuario");
		String pwd = request.getParameter("pwd");
		%>
		
		<h1>La combinación usuario: <%=usuario %> y contraseña <%=pwd %>no es correcta.</h1>
		
	</body>
</html>