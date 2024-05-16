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

public class ComentarioTest {
	
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
		 * Comprobar la selección de un comentario
		 * Todos los comentarios de una noticia específica
		 */
	@Test
	public void selectComentarioTest() {
		Comentario c = em.find(Comentario.class, "Trágico accidente en una Iglesia, Madrid");
		assertEquals("Trágico accidente en una Iglesia, Madrid", c.getNoticia());
	}
	
	
		/**
		 * Comprobar la inserción de un comentario
		 * Encontrar por su autor y comprobar que corresponde
		 */
	@Test
	public void insertComentarioTest() {
		em.getTransaction().begin();
		Comentario nuevoComentario = new Comentario("C4", "Ya era hora!!!", "Norma Colleman");
		em.persist(nuevoComentario);
		em.getTransaction().commit();
		
		Comentario c = em.find(Comentario.class, "Norma");
		assertEquals("Norma", c.getAutor());
	}
	
		/**
		 * Comprobar el borrado de un comentario
		 * Buscar su id y comprobar que se haya eliminado correctamente
		 */
	@Test
	public void borrarComentarioTest() {
		Comentario c = em.find(Comentario.class, "C2");
		
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
		Comentario buscarComentario = em.find(Comentario.class, "C2");
		assertNull(buscarComentario);
	}

	
}
