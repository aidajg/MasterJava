<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calcular nota media</title>
</head>
<body>

<%
String a1 = request.getParameter("literatura");
int asignatura1 = Integer.parseInt(a1);

String a2 = request.getParameter("ciencia");
int asignatura2 = Integer.parseInt(a2);

String a3 = request.getParameter("historia");
int asignatura3 = Integer.parseInt(a3);

int notaMedia = (asignatura1 + asignatura2 + asignatura3) / 3;

 %>
 <p>Nota media de asignaturas es <%=notaMedia %></p>

</body>
</html>