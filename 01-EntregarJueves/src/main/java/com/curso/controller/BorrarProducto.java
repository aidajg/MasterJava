package com.curso.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.Producto;
import com.curso.servicio.TiendaOnline;


public class BorrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\'es\'>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Producto borrado</title>");
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
        
		//Validación
		try {
			//Obtener el producto a eliminar
			String productoBorrar = request.getParameter("eliminado");
		    
		    //Validación : Evitar nulos, espacios en blanco o vacíos
		    if(productoBorrar == null || productoBorrar.isBlank() || productoBorrar.isEmpty()) {
		    	out.print("<p style=\"color:red;\">Nombre inválido.</p>");
				RequestDispatcher rd = request.getRequestDispatcher("/eliminar.jsp");
				rd.include(request, response);
		    }else {
				//Buscar el producto para borrarlo
				for (Producto p : nuevos) {
					if(p.getNombre().equals(productoBorrar)) {
						nuevos.remove(p);
						out.println("<p><strong style='color:red'>Producto </strong>" + p.getNombre() + "<br><strong style='color:red'>Eliminado correctamente.</p></strong>");
						
						//Actualizar la lista de productos
						TiendaOnline tienda = new TiendaOnline();
						tienda.agregarProducto(nuevos);
						
						RequestDispatcher rd = request.getRequestDispatcher("/eliminar.jsp");
					    rd.include(request, response);
					}else {
						out.println("<p><strong style='color:red'>Producto </strong>" + productoBorrar + "<br><strong style='color:red'>no encontrado en almacén.</p></strong>");
						
						RequestDispatcher rd = request.getRequestDispatcher("/eliminar.jsp");
					    rd.include(request, response);
					    break;
					}
				}
				
				
			    
		    }
		    
		//Detectar string y capturar Exception
		} catch (NumberFormatException e) {
		    out.println("<p style=\"color:red;\">Nombre de producto inválido. (evita números)</p>");
		    RequestDispatcher rd = request.getRequestDispatcher("/eliminar.jsp");
		    rd.include(request, response);
		    return;
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}

