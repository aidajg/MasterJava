package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.curso.modelo.Comentario;
import com.curso.modelo.Noticia;

class ComentarioTest extends JPAUnitTest {

	@Test
	void entityManagerFactoryTest() {
		assertNotNull(emf);
	}

	@Test
	void entityManagerTest() {
		assertNotNull(em);
	}
	
	@Test
	void selectComentarioTest() {
		Comentario c = em.find(Comentario.class, 1);
		assertEquals("Marta", c.getAutor());
		
	}

	/**
	 * Seleccionar el comentario 1 (index 0) de una noticia mediante su titulo
	 * 
	 */
	@Test
	void selectNoticiaComentarioTest() {
		Noticia n = em.find(Noticia.class, "Primer titulo");
		Comentario c = n.getComentarios().get(0);
		assertEquals("Marta", c.getAutor());
	}

}


