package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class C04Between {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery consulta = em.createQuery("SELECT l FROM Libro l WHERE l.pvp BETWEEN 30 AND 90", Libro.class);

		List<Libro> lista = consulta.getResultList();
		for(Libro l : lista) {
			System.out.println(l);
		}

	}

}
