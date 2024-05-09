package com.curso.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.Producto;
import com.curso.servicio.TiendaOnline;


public class actualizarPvp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\'es\'>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Modificar Producto</title>");
		out.println("</head>");
		out.println("<body>");
		
		//Obtener la sesion
		HttpSession se = request.getSession(true);
				
		//Array de productos nuevos (se van añadiendo)
		 List<Producto> nuevos = (List<Producto>) se.getAttribute("nuevos");
		 	if (nuevos == null) {
		        nuevos = new ArrayList<>();
		        se.setAttribute("nuevos", nuevos);
		 }
		 
	try {
		//Obtener datos para actualizar producto
		String nombre = request.getParameter("nombre");
		Double pvpNuevo = (double) Double.parseDouble(request.getParameter("pvpNuevo"));
		
		//Detectar nulos
		if(nombre == null || pvpNuevo == null || pvpNuevo <= 0) {
			out.print("<p style=\"color:red;\">Nombre o Pvp inválido.</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/modificar.jsp");
			rd.include(request, response);
		}else {
			//Buscar el producto y modificarlo
			boolean encontrado = false;
			for (Producto p : nuevos) {
				if(nombre.equals(p.getNombre())) {
					p.setPvp(pvpNuevo);
					out.println("<p style=color:green><strong>Se ha actualizado el pvp de <producto style=color:blue>[" + p.getNombre() + "]</producto> a <producto style=color:blue>[" + p.getPvp() + "$]</producto></strong></p>");
					encontrado = true;
					
					//Actualizar la lista de productos
					TiendaOnline tienda = new TiendaOnline();
					tienda.agregarProducto(nuevos);
					
					RequestDispatcher rd = request.getRequestDispatcher("/modificar.jsp");
					rd.include(request, response);
				}
				if (!encontrado) {
					out.println("<br><br>Producto [" + nombre + "] no está en almacén");
					RequestDispatcher rd = request.getRequestDispatcher("/modificar.jsp");
					rd.include(request, response);
					break;
				}
				}
			}
		}catch(Exception e) {
				e.printStackTrace();
				return;
		}

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}


