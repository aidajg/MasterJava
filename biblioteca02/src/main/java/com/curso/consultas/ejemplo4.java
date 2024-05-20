package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Categoria;
import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ejemplo4 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Libro> consulta = em.createQuery("SELECT l FROM Libro l WHERE l.categoria.nombre = 'novela'", Libro.class);
		
		
		List<Libro> lista = consulta.getResultList();
		//Obtener lista de libros que sean Novelas
		for(Libro l : lista) {
			System.out.println(l.toString());
		}
	}
}
