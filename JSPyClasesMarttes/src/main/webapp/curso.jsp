<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List" %>   
<%@ page import="com.cursojava.modelo.Curso" %>
<%@ page import="com.cursojava.service.CursosService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

CursosService cs = new CursosService();
List<Curso> listaCursos = cs.buscarTodos();

for (Curso curso:listaCursos){%>
	<p><%=curso.getNombre()%>, <%=curso.getNivel()%></p>
<%}%>


</body>
</html>