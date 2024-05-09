<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>  
<%@ page import="com.curso.modelo.Producto" %>
<%@ page import="com.curso.servicio.TiendaOnline" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categoria</title>
</head>
<body>
<style>
	body
	{
	font-family: sans-serif;
	}
	
	h2
	{
	text-shadow: 1px 2px 5px rgb(203,152,45);
	margin-left: 160px;
	}
	
	input[type="submit"]{
	color: rgb(255, 255, 255);
	font-size: 16px;
	line-height: 16px;
	padding: 6px;
	margin-left:18px;
	border-radius: 10px;
	text-decoration: none;
	background-image: linear-gradient(to bottom, rgb(203,152,45) 0%, rgb(237,211,78) 50%, rgb(203,152,45) 100%);
	box-shadow: rgba(153, 47, 128, 0.81) -1px 4px 28px 0px inset;
	border: 2px solid rgb(203,152,45);
	display: inline-block;
	}
	
	input[type="submit"]:hover
	{
	background-image:linear-gradient(to bottom, rgb(255,244,56) 0%, rgb(203,152,45) 50%, rgb(255,244,56) 100%);
	border:2px solid white;
	}
	
	
</style>

<!-- Obtener categoria del formulario y obtener productos de la tienda -->
<% String categoria = request.getParameter("categoria");

TiendaOnline tienda = new TiendaOnline();
List<Producto> almacen = tienda.listarTodos();

%>

<h2>Productos encontrados en categoría (<%=categoria%>)</h2>
<hr>

<ul>
<!-- Agregar el producto (viaja por sesion) al almacen  
	 Recorrer el array y sacar los resultados que coincidan -->
<%
HttpSession se = request.getSession();
List<Producto> nuevos = (List<Producto>)se.getAttribute("nuevos");
tienda.agregarProducto(nuevos);

	for (Producto p:almacen){
		p.getNombre();
		if(p.getCategoria().equals(categoria)){%>
			<li><%=p.getNombre()%>, <%=p.getPvp()%>$ (stock:<%=p.getStock()%>)</li>
		<%}
	}%>
</ul>
<br><br>
<a href="buscar.html">Volver atrás</a>
</body>
</html>