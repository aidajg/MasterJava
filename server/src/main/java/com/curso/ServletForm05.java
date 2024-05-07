package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class ServletForm05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\'es\'>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Informe de Empleado</title>");
		out.println("</head>");
		out.println("<body>");
		
		String nombre = request.getParameter("nombre");
		String id = request.getParameter("id");
		out.println("<h3 style=\"color:red;\">EMPLEADO Nº" + id + "</h3>");
		out.println("<strong>" + nombre + "</strong>");
		out.println("");
		String[] options = request.getParameterValues("select");
				for (String option : options) {
				out.println("<br>Departamento: <m style=\"color:green;\">" + option + "</m>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

}
