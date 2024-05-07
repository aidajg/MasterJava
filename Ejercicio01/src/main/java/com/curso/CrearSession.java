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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Enunciado
La aplicación tiene que permitir a un usuario inscribirse en los cursos que le interesen.
Para ello se le mostrará un formulario inicial donde deberá escribir su nombre.
Ese formulario dará paso a una página en la que se mostrará el nombre escrito por el usuario (eco dato)
y un enlace que le permitirá matricularse en un curso.
EL sistema le permite repetir el proceso para matricularse en tantoss cursos como quiera. 
Se muestran los cursos y el nombre del usuario.(Añadir funcionalidades adicionales, borrar curso, etc.)

========
Ejercicio de validación de usuario y password que de la bienvenida al usuario si los datos son correctos
mostrando además la fecha y la hora y elige libremente como quieres que se comporte la aplicación
si los datos son erróneos.
 */

public class CrearSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\'es\'>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Inscripcion</title>");
		out.println("</head>");
		out.println("<body>");
		
		//obtener valores del form
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String fecha = now.format(formatear);
		
		if(name.equals("Ana") && pwd.equals("123")) {
			//Si el inicio de sesión es correcto, se crea la sesión
			HttpSession se = request.getSession(true);
			se.setAttribute("name", name);
			se.setAttribute("pwd", pwd);
			se.setAttribute("fecha", fecha);
			
			se.setMaxInactiveInterval(120);
			
			//Transferir a matriculación
			RequestDispatcher rd = request.getRequestDispatcher("Matriculacion");
			rd.forward(request, response);
		}else {
			//Inicio de sesión incorrecto
			out.print("<h3 style=\"color:red;\">Nombre de usuario o contraseña incorrectos! <br>Pista: Ana,123</h3>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/inscripcion.html");
			rd.include(request, response);
		}

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
