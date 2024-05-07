package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletInvocado extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\'es\'>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Obtener datos del formulario</title>");
		out.println("</head>");
		out.println("<body>");
		
		String user = request.getParameter("usuario");
		String pwd = request.getParameter("password");
		
		if(user.equals("admin") && pwd.equals("123")) {
			out.println("<h3 style=\"color:green;\">Inicio de sesión exitoso.</h3>");
			out.println("Bienvenid@ admin.");
		}else {
			out.println("<h3 style=\"color:red;\">Credenciales incorrectos.</h3>");
			out.println("! Error en el usuario (" + user + ") o contraseña (" + pwd + ")");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
