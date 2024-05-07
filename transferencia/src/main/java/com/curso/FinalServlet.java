package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FinalServlet
 */
public class FinalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"es\">");
		out.println("<head>");
		out.println(" <meta charset=\"UTF-8\">");
		out.println("<title>Servlet Final</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Valor almacenado en request.getParameter(\"userName\"): " + request.getParameter("userName"));
		out.println("<br>");
		out.println("Valor almacenado en request.getAttribute(\"userName\"): " + request.getAttribute("userName"));
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
