package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletForm02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\'es\'>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Mostrar resultado</title>");
		out.println("</head>");
		out.println("<body>");
		
		int numero = Integer.parseInt(request.getParameter("numero"));
		
		for (int i = 0; i < numero; i++) {
			out.println("Bienvenid@<br>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
