<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.cursojava.model.Perfil" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Entrada</title>
	</head>
	<body>
		<%
		String usuario = request.getParameter("usuario");
		Perfil perfil = (Perfil) request.getAttribute("perfil");
		%>
		
		<h1>Bienvenid@ <%=usuario%> a mi página.</h1>
		<h3>Correo: <b><%=perfil.getCorreo() %></b></h3>
		<h3>Edad:  <strong> <%=perfil.getEdad() %></strong></h3>
	</body>
</html>