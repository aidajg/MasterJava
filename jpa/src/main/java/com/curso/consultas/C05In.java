package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class C05In {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery consulta = em.createQuery("SELECT l FROM Libro l WHERE l.autor IN('Amparo Figueroa, 'Ruth Barbados')", Libro.class);
		
		List<Libro> lista = consulta.getResultList();
		for(Libro l : lista) {
			System.out.println(l);
		}

	}

}
