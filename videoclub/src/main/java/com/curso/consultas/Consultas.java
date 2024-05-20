package com.curso.consultas;

import java.util.List;

import com.curso.dominio.Pelicula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Consultas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
		EntityManager em = emf.createEntityManager();
		
		//Mostrar películas
		TypedQuery select01 = em.createQuery("SELECT p FROM Pelicula p", Pelicula.class);
		
		List<Pelicula> listaPeliculas = select01.getResultList();
		for(Pelicula p : listaPeliculas) {
			System.out.println(p.toString());
		}
		
		//Películas del director Cosme
		System.out.println();
		TypedQuery where01 = em.createQuery("SELECT p FROM Pelicula p WHERE p.director = 'Cosme'", Pelicula.class);
		
		List<Pelicula> peliculasCosme = where01.getResultList();
		for(Pelicula p : peliculasCosme) {
			System.out.println(p.toString());
		}
		
		//Películas en las que el director empieza por M
		System.out.println();
		TypedQuery where02 = em.createQuery("SELECT p FROM Pelicula p WHERE p.director LIKE 'M%'", Pelicula.class);
		
		List<Pelicula> directorM = where02.getResultList();
		for(Pelicula p : directorM) {
			System.out.println(p.toString());
		}
		
		
		//Películas cuya directora es Ana o Eva
		System.out.println();
		TypedQuery where03 = em.createQuery("SELECT p FROM Pelicula p WHERE p.director LIKE 'Eva%' OR p.director LIKE 'Ana%'", Pelicula.class);
		
		List<Pelicula> directoras = where03.getResultList();
		for(Pelicula p : directoras) {
			System.out.println(p.toString());
		}
		
		//Mostrar directores
		System.out.println();
		TypedQuery select02 = em.createQuery("SELECT director FROM Pelicula p", Pelicula.class);
		
		List<String> listaDirectores = select02.getResultList();
		for(String director : listaDirectores) {
			System.out.println(director);
		}
		
		//Películas con pvp > 20 y < 55
		System.out.println();
		TypedQuery where04 = em.createQuery("SELECT p FROM Pelicula p WHERE p.pvp > 20 AND p.pvp < 55", Pelicula.class);
		
		List<Pelicula> listaPeliculasPvp = where04.getResultList();
		for(Pelicula p : listaPeliculasPvp) {
			System.out.println(p.toString());
		}
	}
}
