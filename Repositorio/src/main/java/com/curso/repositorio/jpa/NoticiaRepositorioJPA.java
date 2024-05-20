package com.curso.repositorio.jpa;

import com.curso.repositorio.Noticia;

import jakarta.persistence.EntityManager;


public class NoticiaRepositorioJPA implements Noticia{
	private EntityManager entityManager;
	
	//get-set
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//methods
	public Noticia findOne(String titulo) {
		return entityManager.find(Noticia.class, titulo);
	}

	public Iterable<Noticia> findAll() {
		return entityManager.createQuery("SELECT n FROM Noticia n").getResultList();
	}

	public void save(Noticia noticia) {
		entityManager.persist(noticia);
	}

	public void delete(Noticia noticia) {
		entityManager.remove(noticia);
	}

}
