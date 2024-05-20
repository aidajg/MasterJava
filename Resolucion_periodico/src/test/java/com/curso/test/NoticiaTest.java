package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.curso.modelo.Noticia;

@TestMethodOrder(OrderAnnotation.class)
class NoticiaTest extends JPAUnitTest {
	
	@Test
	@Order(1)
	void entityManagerFactoryTest() {
		assertNotNull(emf);
	}

	@Test
	@Order(2)
	void entityManagerTest() {
		assertNotNull(em);
	}
	
	@Test
	@Order(3)
	void selectNoticiaTest() {
		Noticia n = em.find(Noticia.class, "Primer titulo");
		assertEquals("Aida J", n.getAutor());
		
	}
	
	@Test
	@Order(4)
	void deleteNoticiaTest() {
		Noticia n = em.find(Noticia.class, "Primer titulo");
		em.getTransaction().begin();
		em.remove(n);
		em.getTransaction().commit();
		
		Noticia buscar = em.find(Noticia.class, "Primer titulo");
		assertNull(buscar);
		
	}
	
	@Test
	@Order(5)
	void insertNoticiaTest() {
		em.getTransaction().begin();
		Noticia n = new Noticia("Segunda Noticia", "Alguien", LocalDate.now());
		em.persist(n);
		em.getTransaction().commit();
		
		Noticia buscar = em.find(Noticia.class, "Segunda Noticia");
		assertEquals("Segunda Noticia", buscar.getTitulo());
		
	}
}
