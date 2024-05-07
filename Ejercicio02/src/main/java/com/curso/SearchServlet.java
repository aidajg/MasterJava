package com.curso;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoger dato de formulario
		String busqueda = request.getParameter("tema");
		//array de tematicas
		ArrayList<String> tematicas = new ArrayList<>();
		tematicas.add("cocina");
		tematicas.add("programacion");
		tematicas.add("decoracion");
		
		//session
		HttpSession se = request.getSession(true);
		se.setAttribute("tema", busqueda);
		se.setAttribute("array", tematicas);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//dato no puede ser nulo
		if(busqueda != null) {
			boolean encontrado = false;
			//recorrer array y comprobar que coincide algún valor con el dato de búsqueda
			for (int i = 0; i < tematicas.size(); i++) {
				if(busqueda.equals(tematicas.get(i))) { // {cocina, programacion, decoracion}
					//Transferir a enlaces servlet
					RequestDispatcher rd = request.getRequestDispatcher("EnlacessServlet");
					rd.forward(request, response);
					encontrado = true;
					break;
				}
			}
			if(!encontrado) {
					//Tematica no registrada
					out.print("<h3 style=\"color:red;\">Temática no registrada.<br>Por favor, introduce una válida.</h3>");
					
					RequestDispatcher rd = request.getRequestDispatcher("/form.html");
					rd.include(request, response);
				}
			}
		}
		
	}
