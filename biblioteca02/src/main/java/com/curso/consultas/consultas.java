package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Categoria;
import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class consultas {
	//Console colors
	public static final String ANSI_RED = "\u001B[31m"; //rojo
	public static final String ANSI_CYAN = "\u001B[36m"; //cian
	
	//Quitar color
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Crear un libro y buscar una categoría para setear
		Libro miLibro = new Libro("A12", "Instalación de Lavadora G600 CL", "Jacinta Bellido", 45);
		
		Categoria categoria = em.find(Categoria.class, "Manual");
		miLibro.setCategoria(categoria);
		em.persist(miLibro);
		
		em.getTransaction().commit();
		
		
		//Mostrar todos los libros
		TypedQuery<Libro> listarLibros = em.createNamedQuery("listarLibros", Libro.class);
		
		List<Libro> lista = listarLibros.getResultList();
		
		System.out.println("* * * * * * * * * BIBLIOTECA * * * * * * * * *");
		int i = 0;
		for(Libro l : lista) {
			i++;
			System.out.println(i + ") '" + ANSI_CYAN + l.getTitulo() + ANSI_RESET + "' de " + l.getAutor() + " [ISBN : "+ l.getIsbn() + "], precio: " + ANSI_RED + l.getPvp() + "$" + ANSI_RESET);
		}
		System.out.println();
		
		
	}
}
