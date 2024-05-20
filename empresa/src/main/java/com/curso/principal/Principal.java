package com.curso.principal;

import java.util.List;

import com.curso.dominio.Departamento;
import com.curso.dominio.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Principal {
	//Console colors
	public static final String ANSI_YELLOW = "\u001B[33m"; //amarillo
	public static final String ANSI_CYAN = "\u001B[36m"; //cian
	
	//Quitar color
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empresa");
		EntityManager em = emf.createEntityManager();
		
		//Crear un nuevo empleado y asignarlo a un departamento existente (RRHH)
		em.getTransaction().begin();
		Empleado nuevoEmpleado = new Empleado(7, "Dolores Ramirez", "2024-05-13", 1200);
		
		Departamento id_dept = em.find(Departamento.class, 2);
		nuevoEmpleado.setId_departamento(id_dept);
		
		em.getTransaction().commit();
		
		
		//Mostrar todos los departamentos
		TypedQuery<Departamento> consulta = em.createNamedQuery("listarDepartamentos", Departamento.class);
		
		List<Departamento> listaDept = consulta.getResultList();
		
		System.out.println("- - - - - - - - - DEPARTAMENTOS - - - - - - - - -");
		for(Departamento d : listaDept) {
			System.out.println(ANSI_CYAN + "ID " + d.getId() + ANSI_RESET + ") '" + d.getNombre() + "' ubicado en " + ANSI_YELLOW + d.getLocalidad() + ANSI_RESET);
		}
		System.out.println();
		
		//Mostrar empleados
		TypedQuery<Empleado> consulta2 = em.createNamedQuery("listarEmpleados", Empleado.class);
		
		List<Empleado> listaEmp = consulta2.getResultList();
		
		System.out.println("- - - - - - - - - EMPLEADOS - - - - - - - - -");
		for(Empleado e : listaEmp) {
			System.out.println(ANSI_YELLOW + "ID " + e.getId() + ANSI_RESET + ") '" + e.getNombre() + "' trabaja en Departamento " + ANSI_CYAN + e.getId_departamento() + ANSI_RESET);
		}
		System.out.println();
		
		//Mostrar todos los empleados de un departamento (Marketing "3")
//		TypedQuery<Empleado> consulta3 = em.createNamedQuery("buscarPorDept", Empleado.class);
//		consulta2.setParameter("id", 3);
//		
//		List<Empleado> empleadosMarketing = consulta3.getResultList();
//		for(Empleado e : empleadosMarketing) {
//			System.out.println(e.toString());
//		}
		
		//Seleccionar los departamentos con menos de x empleados
		TypedQuery<Object[]> consulta3 = em.createQuery("SELECT d.nombre, count(e.id_departamento) FROM Empleado e INNER JOIN Departamento d ON d.id = e.id_departamento GROUP BY d.nombre HAVING count(e.id_departamento) < 3 ORDER BY d.nombre", Object[].class);
		
		
		List<Object[]> lista1 = consulta3.getResultList();
		for(Object[] e : lista1) {
			System.out.println("En el departamento " + e[0] + " hay " + e[1] + " empleado(s).");
		}
		
		//Seleccionar empleados que ganan menos que el promedio
		TypedQuery<Empleado> consulta4 = em.createQuery("SELECT e.nombre, e.sueldo FROM Empleado e WHERE e.sueldo < (SELECT avg(e.sueldo) FROM Empleado e)", Empleado.class);
		
		
		List<Empleado> lista2 = consulta4.getResultList();
		for(Empleado e : lista2) {
			System.out.println(e.toString());
		}
	}

}
