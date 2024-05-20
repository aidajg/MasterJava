package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Alumno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class A01Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("centro");
		EntityManager em = emf.createEntityManager();
		
		//Mostrar a todos los alumnos
		TypedQuery<Alumno> buscarTodos = em.createNamedQuery("buscarTodos", Alumno.class);
		
		List<Alumno> listaAlumnos = buscarTodos.getResultList();
		
		System.out.println("* * * * * * * * * ALUMNOS * * * * * * * * *");
		
		for(Alumno a : listaAlumnos) {
			System.out.println(a.getNombre() + " " + a.getApellido() + " [Curso] " + a.getCurso());
		}
		System.out.println();
		
		//Buscar alumno con ID 8
		TypedQuery<Alumno> buscarPorId = em.createNamedQuery("buscarPorId", Alumno.class);
		buscarPorId.setParameter("id", 8);
		
		List<Alumno> alumno8 = buscarPorId.getResultList();
		
		System.out.println("* * * * * * * * * ¿Alumno con ID 8? * * * * * * * * *");
		for(Alumno a : alumno8) {
			System.out.println(a.getNombre() + " " + a.getApellido());
		}
		System.out.println();
		
		
		//Buscar alumno por nombre 'Lorena'
		TypedQuery<Object[]> buscarPorNombre = em.createNamedQuery("buscarPorNombre", Object[].class);
		buscarPorNombre.setParameter("nombre", "Lorena");
				
		List<Object[]> lorenas = buscarPorNombre.getResultList();
				
		System.out.println("* * * * * * * * * ¿Cuántas alumnas se llaman Lorena? * * * * * * * * *");

		for(Object[] l : lorenas) {
			System.out.println("Hay " + l[0] + " alumnas llamadas Lorena");
		}
		System.out.println();
		
		
		//Buscar alumno por apellido 'Blanco'
		TypedQuery<Object[]> buscarPorApellido = em.createNamedQuery("buscarPorApellido", Object[].class);
		buscarPorApellido.setParameter("apellido", "Blanco");
						
		List<Object[]> blancos = buscarPorApellido.getResultList();
						
		System.out.println("* * * * * * * * * ¿Cuántos alumnos se apellidan Blanco? * * * * * * * * *");

		for(Object[] bl : blancos) {
			System.out.println("Actualmente hay " + bl[0] + " alumnos con apellido Blanco");
		}
		System.out.println();
		
	}
}
