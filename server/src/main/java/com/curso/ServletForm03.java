package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletForm03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\'es\'>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Cursos elegidos</title>");
		out.println("</head>");
		out.println("<body>");
		
		if(request.getParameter("yoga") != null) {
			out.println("Has seleccionado yoga!<br>");
		}
		if(request.getParameter("pilates") != null) {
			out.println("Has seleccionado pilates!<br>");
		}
		if(request.getParameter("boxeo") != null) {
			out.println("Has seleccionado boxeo!<br>");
		}
		if(request.getParameter("mma") != null) {
			out.println("Has seleccionado MMA!<br>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
