package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class C06OrderBy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //unidad de persistencia
		EntityManager em = emf.createEntityManager();
		
		//El count(*) devolverá un array de objetos
		TypedQuery<Object[]> consulta = em.createQuery("SELECT COUNT(l.pvp), l.pvp FROM LIBRO l GROUP BY l.pvp", Object[].class);
		
		List<Object[]> lista = consulta.getResultList();
		
		/*
		 * Índice [1] --> señala el precio
		 * Índice [0] --> los elementos que hay de ese precio
		 */
		
		for(Object[] sublista : lista) {
			System.out.println("De precio " + sublista[1] + " hay " + sublista[0] + " libros.");
		}
	}
}
