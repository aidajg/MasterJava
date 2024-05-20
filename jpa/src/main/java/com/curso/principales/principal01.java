package com.curso.principales;

import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class principal01 {
	public static void main(String[] args) {
		
		/*
		 * Persistence ---> EntityManagerFactory ---> EntityManager ---> Entity
		 * 												|
		 * 												v
		 * 							  EntityTransaction --- Query
		 */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); //unidad de persistencia
		EntityManager em = emf.createEntityManager();
		
		Libro libro = em.find(Libro.class, "1A"); //buscar un registro
		System.out.println(libro.getIsbn());
		System.out.println(libro.getTitulo());
		System.out.println(libro.getAutor());
		System.out.println(libro.getPvp());
	}
}
