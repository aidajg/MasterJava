<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matriz tablas de multiplicar</title>
</head>
<body>
<!-- 
Ejercicio tabla multiplicar
1 2 3 4 5 6 7 8 9 10
2 4 6 8 ...
3 . . .
 -->
 <h2>Tablas de multiplicar</h2>
 <table border="1" style="align-content:center">
 <tr>
<%
for(int i = 1; i < 11; i++){%>
	</tr><th><%="Número: " + i%></th>
	<%for(int j = 1; j < 11; j++){%>
	<td><%=j*i%></td>
	<%} %>
<%} %>

</table>

</body>
</html>