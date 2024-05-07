package com.curso;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MayusServlet
 */
public class MayusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Este servlet convierte el valor del userName a mayúscula
        //y no genera contenido. Eso se lo deja al ServletFinal
        
        String nombre = request.getParameter("name");
        request.setAttribute("name", nombre.toUpperCase());
        RequestDispatcher despachador = request.getRequestDispatcher("/FinalServlet");
        despachador.forward(request, response);
	}

}
