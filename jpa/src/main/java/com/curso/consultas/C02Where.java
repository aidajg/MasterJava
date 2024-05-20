package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class C02Where {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery consulta = em.createQuery("SELECT l FROM Libro l WHERE l.autor = :autor", Libro.class);
		consulta.setParameter("autor", "Amparo Figueroa");
		
		List<Libro> lista = consulta.getResultList();
		for(Libro l : lista) {
			System.out.println(l);
		}

	}

}
