package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibroTest {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	/**
	 * Arrange (organizar)	-	Act (ejecutar)	-	Assert(aseverar)
	 * 
	 * Iniciar() -> crea la entityMF con unidad de persistencia bd 'biblioteca03' y establece el entityM
	 * @BeforeEach -> Ocurre antes que cualquier acción
	 */
	
	@BeforeEach
	void iniciar() {
		emf=Persistence.createEntityManagerFactory("biblioteca03");
		em = emf.createEntityManager();
	}
	
		//Comprobar que el emf existe (not null)
	@Test
	public void entityManagerFactoryTest() {
		assertNotNull(emf);
	}

		//Comprobar el em (not null)
	
	@Test
	public void entityManagerTest() {
		assertNotNull(em);
	}

		/**
		 * Comprobar la selección de un libro
		 * esperando que el valor de autor sea pepito
		 */
	@Test
	public void seleccionarLibroTest() {
		Libro l = em.find(Libro.class, "1AB");
		assertEquals("pepito", l.getAutor());
	}
	
	
		/**
		 * Comprobar la inserción de un libro
		 * Encontrar ese mismo libro por su isbn
		 */
	@Test
	public void insertarLibroTest() {
		em.getTransaction().begin();
		Libro l = new Libro("7HI", "Comidas Copiosas", "Chef Cuisine", 50);
		em.persist(l);
		em.getTransaction().commit();
		
		Libro libro = em.find(Libro.class, "7HI");
		assertEquals("7HI", libro.getIsbn());
	}
	
		/**
		 * Comprobar el borrado de un libro
		 * Buscar su isbn y comprobar que sea nulo
		 */
	@Test
	public void borrarLibroTest() {
		Libro libro = em.find(Libro.class, "1AB");
		
		em.getTransaction().begin();
		em.remove(libro);
		em.getTransaction().commit();
		
		Libro buscar = em.find(Libro.class, "1AB");
		assertNull(buscar);
	}

	
}
