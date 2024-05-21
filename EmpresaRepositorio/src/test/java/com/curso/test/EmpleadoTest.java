package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.curso.modelo.Departamento;
import com.curso.modelo.Empleado;

@TestMethodOrder(OrderAnnotation.class)
class EmpleadoTest extends JPAUnitTest {

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
	void selectEmpleadoTest() {
		Empleado e = em.find(Empleado.class, 1);
		assertEquals(1, e.getId());
		
	}

	/**
	 * Seleccionar el empleado 1 (index 0)
	 * del departamento RRHH
	 * 
	 */
	@Test
	@Order(4)
	void selectEmpleadoDepartamentoTest() {
		Departamento d = em.find(Departamento.class, "RRHH");
		Empleado e = d.getEmpleados().get(0);
		assertEquals(d, e.getNombre_departamento());
	}
	
	/**
	 * Seleccionar el empleado 1 (index 0)
	 * del departamento RRHH
	 * 
	 */
	@Test
	@Order(5)
	void deleteEmpleadoTest() {
		Empleado e = em.find(Empleado.class, 1);
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		
		Empleado buscar = em.find(Empleado.class, 1);
		assertNull(buscar);
	}

//	@Test
//	@Order(5)
//	void insertEmpleadoTest() {
//		em.getTransaction().begin();
//		Empleado e = new Empleado("Lorena Sánchez", LocalDate.now(), 1500, "RRHH");
//		em.persist(e);
//		em.getTransaction().commit();
//		
//		Empleado buscar = em.find(Empleado.class, "Lorena Sánchez");
//		assertEquals("Lorena Sánchez", buscar.getNombre());
//		
//	}

}


