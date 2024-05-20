package com.cursojava.controller;

import java.io.IOException;

import com.cursojava.model.Perfil;
import com.cursojava.service.ValidacionService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidacionService service;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String pwd = request.getParameter("pwd");

		service = new ValidacionService();
		Perfil temporal = service.autenticar(usuario, pwd);
		
		if (temporal != null) {
			request.setAttribute("perfil", temporal);
			RequestDispatcher dispatcher = request.getRequestDispatcher("entrada.jsp");
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
}

