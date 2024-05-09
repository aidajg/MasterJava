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

public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\'es\'>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Producto agregado</title>");
		out.println("</head>");
		out.println("<body>");
		
		//Crear la sesion (viajan los productos nuevos)
		HttpSession se = request.getSession(true);
		
		//Array de productos nuevos (se van añadiendo)
        List<Producto> nuevos = (List<Producto>) se.getAttribute("nuevos");
        if (nuevos == null) {
            nuevos = new ArrayList<>();
            se.setAttribute("nuevos", nuevos);
        }
		
		//Obtener datos de formulario (de nuevo producto)
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		
		//Validación : Evitar string en pvp y stock
		try {
		    Double pvp = Double.parseDouble(request.getParameter("pvp"));
		    Integer stock = Integer.parseInt(request.getParameter("stock"));
		    
		    //Validación : Evitar nulos, espacios en blanco, vacíos y números negativos o ceros
		    if(pvp == null || stock == null || nombre == null || categoria == null) {
		    	out.print("<p style=\"color:red;\">No se admiten nulos.</p>");
				RequestDispatcher rd = request.getRequestDispatcher("/agregar.html");
				rd.include(request, response);
		    }else {
		    	if(pvp <= 0 || stock <= 0) {
		    		out.println("<p style=\"color:red;\">No puede ser menor o igual que cero.</p>");
					RequestDispatcher rd = request.getRequestDispatcher("/agregar.html");
					rd.include(request, response);
		    	}else if(nombre.isBlank() || nombre.isEmpty()){
					out.println("<p style=\"color:red;\">Nombre no puede contener espacios ni vacios.</p>");
					RequestDispatcher rd = request.getRequestDispatcher("/agregar.html");
					rd.include(request, response);
		    	}
		    	//Agregar a la variable de sesion como nueva instancia
				nuevos.add(new Producto(nombre, categoria, pvp, stock));
				out.println("<h2>Registro de movimientos</h2>");
				out.println("<hr><br>");
				//Imprimir el ultimo añadido si coinciden por nombre
				for (Producto p : nuevos) {
					if(p.getNombre().equals(nombre)) {
						out.println("<p><strong style='color:green'>Producto </strong>" + p.toString() + "<br><strong style='color:green'>agregado con éxito!</p></strong>");
						break;
					}
				}
				out.println("<a href='index.html'>Volver al menú</a>");
				out.println("<a href='agregar.html'>Agregar más</a>");
		    }
		    
		//Detectar string y capturar Exception
		} catch (NumberFormatException e) {
		    out.println("<p style=\"color:red;\">Pvp (entero o decimal) o Stock (entero) inválidos.</p>");
		    RequestDispatcher rd = request.getRequestDispatcher("/agregar.html");
		    rd.include(request, response);
		    return;
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}

