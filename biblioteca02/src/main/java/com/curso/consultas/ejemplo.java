package com.curso.consultas;

import java.util.ArrayList;
import java.util.List;

import com.curso.dominio.Categoria;
import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ejemplo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Categoria categoria = new Categoria("Terror", "Mucho miedo");
		
		Libro l1 = new Libro("A13", "Pesadilla en la calle 13", "Dominique D'Andre", 50);
		Libro l2 = new Libro("A14", "Navidad con la familia Baskin", "Shaniqua Bea", 53);
		
		l1.setCategoria(categoria);
		l2.setCategoria(categoria);
		
		List<Libro> lista = new ArrayList<Libro>();
		lista.add(l1);
		lista.add(l2);
		
		/**
		 * Mandar lista a array libros de categoria
		 * y convertir a instancias persistentes
		 */
		categoria.setLibros(lista);
		em.persist(categoria);
		em.persist(l1);
		em.persist(l2);
		em.getTransaction().commit();
		
	}
}
