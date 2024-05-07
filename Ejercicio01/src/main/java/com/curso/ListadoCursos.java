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
 * Servlet implementation class ListadoCursos
 */
public class ListadoCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener el nombre a través de la recuperacion de la sesión
		HttpSession se = request.getSession(true);
		String nombre = (String) se.getAttribute("name");
		String fecha = (String) se.getAttribute("fecha");
		
		//Crear la lista de cursos y añadir como atributo de sesion
		ArrayList<String> listaCursos = new ArrayList<>();
		se.setAttribute("arrayCursos", listaCursos);
		
		String curso = request.getParameter("curso");
		se.setAttribute("curso", listaCursos);
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println(" <meta charset=\"UTF-8\">");
		out.println("<title>Listado de cursos</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style=\"color:blue;\">Cursos de " + nombre + "</h2>");
		out.println("<h3 style=\"color:orange;\">Fecha de inscripción: " + fecha + "</h3>");
		if(curso != null && !curso.isEmpty()) {
			//Si curso no es nulo o array tiene cursos, añadir al array y mostrar en la lista
			listaCursos.add(curso);
			for (String c : listaCursos) {
				out.println("<ul>");
				out.println("<li>" + c + "</li><a href='borrarCurso?curso='" + c + ">Eliminar</a>");
				out.println("</ul>");
			}
		}else {
			out.println("No hay cursos.");
		}
		out.println("<a href='form.html'>Añadir más cursos</a>");
		out.println("<a href='inscripcion.html'>Cerrar Sesión</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
