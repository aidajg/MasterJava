package com.curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LeerProducto
 */
public class LeerProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		Producto producto = (Producto) se.getAttribute("producto");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		if(producto != null) {
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\'es\'>");
			out.println("<head>");
			out.println("<meta charset=\'UTF-8\'>");
			out.println("<title>Leer Producto</title>");
			out.println("</head>");
			out.println("<body>");
			out.println(producto.getId() + " " + producto.getConcepto() + " " + producto.getPrecio());
			out.println("</body>");
			out.println("</html>");
			out.close();
		}else {
			out.println("Producto es null.");
		}
	}

}
