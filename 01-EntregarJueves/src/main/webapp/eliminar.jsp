<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="java.util.ArrayList" %>  
<%@ page import="java.util.List" %>  
<%@ page import="com.curso.modelo.Producto" %>
<%@ page import="com.curso.controller.Session" %>
<%@ page import="com.curso.servicio.TiendaOnline" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar productos</title>
</head>
<body>
<style>
	body
	{
	font-family: sans-serif;
	}
	
	h2
	{
	text-shadow: 1px 2px 5px red;
	margin-left: 160px;
	}
	
	input[type="submit"]{
	color: black;
	font-size: 16px;
	line-height: 16px;
	padding: 6px;
	margin-left:18px;
	margin-right:18px;
	border-radius: 10px;
	text-decoration: none;
	background-image: linear-gradient(to bottom, red 0%, coral 50%, red 100%);
	box-shadow: rgba(153, 47, 128, 0.81) -1px 4px 28px 0px inset;
	border: 2px solid rgb(203,152,45);
	display: inline-block;
	}
	
	input[type="submit"]:hover
	{
	background-image:linear-gradient(to bottom, coral 0%, red 50%, coral 100%);
	border:2px solid white;
	color:white;
	}
	
	
</style>

<h2>Eliminar un producto</h2>
<hr><br>
<form action="BorrarProducto" method="post">
	Nombre: <input type="text" name="eliminado">
	<input type="submit" value="Borrar">
	<a href="index.html">Volver atras</a>
</form>

<br><br>
<hr>
<h3>Actualmente en almacén:</h3>
<%
//Obtener array de productos
TiendaOnline tienda = new TiendaOnline();
List<Producto> almacen = tienda.listarTodos();

HttpSession se = request.getSession();
List<Producto> nuevos = (List<Producto>)se.getAttribute("nuevos");

tienda.agregarProducto(nuevos);

	for (Producto p:almacen){%>
			<li><%=p.getNombre()%>, <%=p.getPvp()%>$ (stock:<%=p.getStock()%>)</li>
		<%}%>
</body>
</html>
</body>
</html>