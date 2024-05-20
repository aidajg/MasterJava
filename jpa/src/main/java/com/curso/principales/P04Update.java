package com.curso.principales;

import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class P04Update {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		Libro libro = em.find(Libro.class, "1A");
		em.getTransaction().begin();
		libro.setPvp(80);
		libro.setAutor("Amparo Figueroa");
		em.merge(libro); //Actualizar el registro
		em.getTransaction().commit();
	}
}
