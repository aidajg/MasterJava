<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.curso.Persona" %>
<%
//datos formulario
String nom = request.getParameter("nombre");
String ape = request.getParameter("ape");
String edad = request.getParameter("edad");
String nie = request.getParameter("dni");
String trabajo = request.getParameter("puesto");

//crear Persona y pasar parámetros por constructor
Persona p1 = new Persona(nom, ape, edad, nie, trabajo);
%>

<!-- Mostrar datos -->
<h2 style=color:orange>Persona Registrada:</h2>
<p>Nombre: <%=p1.nombre%></p>
<p>Apellido: <%=p1.apellido%></p>
<p>Fecha Nacimiento: <%=p1.edad%></p>
<p>DNI: <%=p1.dni%></p>
<p>Puesto de trabajo: <%=p1.puesto%></p>

</body>
</html>