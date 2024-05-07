package com.curso;

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
 * Servlet implementation class EnlacessServlet
 */
public class EnlacessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtener el dato con session
		HttpSession se = request.getSession(true);
		String busqueda = (String) se.getAttribute("tema");
		ArrayList<String> tematicas = (ArrayList<String>) se.getAttribute("array");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println(" <meta charset=\"UTF-8\">");
		out.println("<title>Enlaces encontrados</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 style=\"color:orange;\">Temática: " + busqueda + "</h2>");
		//Mostrar html según tematica
		boolean encontrado = false;
		for (String t : tematicas) {
			if(busqueda.equals("cocina") && t.equals(("cocina") )) {
				out.println("<a href='https://www.bonviveur.es/recetas/'>www.bonviveur.es</a>");
				out.print("<h3 style=\"color:green;\">Recetas fáciles y caseras!</h3><hr>");
				out.println("<a href='https://www.lecturas.com/recetas/'>www.lecturas.com</a>");
				out.print("<h3 style=\"color:green;\">Más de 10.000 recetas</h3><hr>");
				out.println("<a href='https://www.ifema.es/noticias/alimentacion-bebidas/trucos-de-cocinas-basicos-sencillos'>www.trucoscocina.com</a>");
				out.print("<h3 style=\"color:green;\">Te convertiras en un experto cocinero</h3><hr>");
				out.println("<a href='form.html'>Volver atrás</a>");
				encontrado = true;
				break;
			}else if(busqueda.equals("programacion") && t.equals(("programacion") ))  {
				out.println("<a href='https://weremote.net/programar-mas-rapido/'>www.weremote.net</a>");
				out.print("<h3 style=\"color:green;\">10 tips para programar mas rapido!</h3><hr>");
				out.println("<a href='https://aprendepython.es/'>www.aprendepython.es</a>");
				out.print("<h3 style=\"color:green;\">Aprende Python desde casa</h3><hr>");
				out.println("<a href='https://docs.oracle.com/javase/8/docs/api/'>www.docs.oracle.com</a>");
				out.print("<h3 style=\"color:green;\">API de Java</h3><hr>");
				out.println("<a href='form.html'>Volver atrás</a>");
				encontrado = true;
				break;
			}else if(busqueda.equals("decoracion") && t.equals(("decoracion") ))  {
				out.println("<a href='https://www.ikea.com/es/es/customer-service/brochures/'>www.ikea.com</a>");
				out.print("<h3 style=\"color:green;\">Los mejores muebles!</h3><hr>");
				out.println("<a href='form.html'>Volver atrás</a>");
				encontrado = true;
				break;
			}
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
