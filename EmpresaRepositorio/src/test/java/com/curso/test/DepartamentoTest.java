package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.curso.modelo.Departamento;

@TestMethodOrder(OrderAnnotation.class)
class DepartamentoTest extends JPAUnitTest {
	
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
	
	/**
	 * Select Departamento
	 * Comprobar que se ha realizado correctamente buscando por localidad
	 */
	@Test
	@Order(3)
	void selectDepartamentoTest() {
		Departamento d = em.find(Departamento.class, "Telecomunicaciones");
		assertEquals("Telecomunicaciones", d.getNombre());
		
	}
	
	/**
	 * Delete Departamento
	 * Comprobar que se ha realizado correctamente buscando por nombre 
	 */
	@Test
	@Order(4)
	void deleteDepartamentoTest() {
		Departamento d = em.find(Departamento.class, "Telecomunicaciones");
		em.getTransaction().begin();
		em.remove(d);
		em.getTransaction().commit();
		
		Departamento buscar = em.find(Departamento.class,  "Telecomunicaciones");
		assertNull(buscar);
		
	}
	
	/**
	 * Insert new Departamento
	 * Comprobar que se ha realizado correctamente buscando por nombre 
	 */
	@Test
	@Order(5)
	void insertDepartamentoTest() {
		em.getTransaction().begin();
		Departamento d = new Departamento("Telecomunicaciones", "Madrid");
		em.persist(d);
		em.getTransaction().commit();
		
		Departamento buscar = em.find(Departamento.class, "Telecomunicaciones");
		assertEquals("Telecomunicaciones", buscar.getNombre());
		
	}
}
