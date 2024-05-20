package com.curso.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class JPAUnitTest {

	static EntityManagerFactory emf;
	EntityManager em;
		
	/**
	 * Refactorizar los elementos comunes en un solo class
	 * Método Iniciar con beforeEach --> Iniciar el schema mediante ud. persistencia
	 * Inicializar ambas entidades
	 */
	@BeforeAll
	static void setupStaticTest() {
		Persistence.generateSchema("noticias", null);
		emf = Persistence.createEntityManagerFactory("noticias");
	}
	
	@BeforeEach
	void setupTest() {
		em = emf.createEntityManager();
	}
	
	//Cerrar cada una de las conexiones para evitar sobresaturar el pool
	@AfterEach
	void downTest() {
		em.clear();
		em.close();
	}
	
	@AfterAll
	static void downStaticTest() {
		emf.close();
	}

}
