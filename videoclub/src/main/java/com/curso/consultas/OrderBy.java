package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Pelicula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class OrderBy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * Insertar registors de películas donde se repita el precio en alguna de ellas.
		 * Después hacer una consulta que nos diga cuantas películas hay de cada uno de 
		 * los precios que aparecen en los registros de la tabla de la base de datos.
		 * 
		 */
		
		TypedQuery<Object[]> consulta = em.createQuery("SELECT COUNT(p.pvp), p.pvp FROM Pelicula p GROUP BY p.pvp", Object[].class);
		
		List<Object[]> lista = consulta.getResultList();
		
		/*
		 * Índice [1] --> señala el precio
		 * Índice [0] --> los elementos que hay de ese precio
		 */
		
		for(Object[] sublista : lista) {
			System.out.println("De precio " + sublista[1] + " hay " + sublista[0] + " películas.");
			
		}
	}
}
