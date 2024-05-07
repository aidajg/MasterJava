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
 * Servlet implementation class BorrarCurso
 */
public class BorrarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Eliminar el curso de la lista
			HttpSession se = request.getSession(true);
			String curso = request.getParameter("curso");
			se.getAttribute("arrayCursos");
			listaCursos.remove(eliminar);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListadoCursos");
	        rd.forward(request, response);
		}

}
