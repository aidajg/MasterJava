package com.curso;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		if(pwd.equals("123")) {
			//Enviar solicitud a otro servlet (Login2)
			RequestDispatcher rd = request.getRequestDispatcher("Login2");
			rd.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.print("Password Incorrecta.");
			
			RequestDispatcher rd = request.getRequestDispatcher("/form.html");
			rd.include(request, response);
		}
		
	}

}
