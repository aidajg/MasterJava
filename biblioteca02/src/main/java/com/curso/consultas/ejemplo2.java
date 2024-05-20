package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ejemplo2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Categoria> consulta = em.createQuery("SELECT c FROM Categoria c", Categoria.class);
		
		
		List<Categoria> lista = consulta.getResultList();
		for(Categoria c : lista) {
			System.out.println(c.toString());
		}
	}
}
