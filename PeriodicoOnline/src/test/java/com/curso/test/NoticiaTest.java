package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.dominio.Comentario;
import com.curso.dominio.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NoticiaTest {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	/**
	 * Arrange (organizar)	-	Act (ejecutar)	-	Assert(aseverar)
	 * 
	 * Iniciar() -> crea la entityMF con unidad de persistencia bd 'periodico' y establece el entityM
	 * @BeforeEach -> Ocurre antes que cualquier acción
	 */
	
	@BeforeEach
	void iniciar() {
		emf=Persistence.createEntityManagerFactory("periodico");
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
		 * Comprobar la selección de una noticia
		 * El autor tiene que ser 'Lorena'
		 */
	@Test
	public void selectNoticiaTest() {
		Noticia n = em.find(Noticia.class, "Rescatan cinco cachorros abandonados");
		assertEquals("Lorena", n.getAutor());
	}
	
	
		/**
		 * Comprobar la inserción de una noticia
		 * Encontrarla por su autor 'Carlos' y comprobar que el título corresponde
		 */
	@Test
	public void insertNoticiaTest() {
		em.getTransaction().begin();
		Noticia nuevaNoticia = new Noticia("Fallece Donald Trump", "Carlos Espinosa", "2024-06-06");
		em.persist(nuevaNoticia);
		em.getTransaction().commit();
		
		Noticia n = em.find(Noticia.class, "Carlos");
		assertEquals("Fallece Donald Trump", n.getTitulo());
	}
}
