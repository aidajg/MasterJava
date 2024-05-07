<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cursos</title>
</head>
<body>

<%
	String c1 = "Chino";
	String c2 = "Ruso";
	String c3 = "Italiano";
	
	List <String> listaCursos = new ArrayList<String>();
	listaCursos.add(c1);
	listaCursos.add(c2);
	listaCursos.add(c3);
%>

<h2> Cursos usando párrafos</h2>

<%
for(int i = 0; i < listaCursos.size(); i++){%>
	<p><%=listaCursos.get(i)%></p>
<%} %>


<h2> Cursos usando tablas de una fila</h2>
<table border="1">
<tr>
<%
for(int i = 0; i < listaCursos.size(); i++){%>
	<th><%=listaCursos.get(i)%></th>
<%} %>
<tr>
</table>


<h2> Cursos usando tablas de una columna</h2>
<table border="1">
<td style=background-color:red;>
<%
for(int i = 0; i < listaCursos.size(); i++){%>
	<%=listaCursos.get(i)%><br>
<%} %>
</td>
</table>

<h2> Cursos usando una lista</h2>
<ul>
<%
for(int i = 0; i < listaCursos.size(); i++){%>
	<li><%=listaCursos.get(i)%></li>
<%} %>

</ul>
</body>
</html>