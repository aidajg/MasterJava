package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Categoria;
import com.curso.dominio.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ejemplo3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		//Seleccionar las categorías con menos de 3 libros
		
		TypedQuery<Categoria> consulta = em.createQuery("SELECT c FROM Categoria c WHERE SIZE(c.libros) < 3", Categoria.class);
		
		
		List<Categoria> lista = consulta.getResultList();
		//Obtener lista de libros que sean Novelas
		for(Categoria c : lista) {
			System.out.println(c.toString());
		}
	}
}
