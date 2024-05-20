package com.curso.repositorio.jpa;

import com.curso.repositorio.Comentario;

import jakarta.persistence.EntityManager;

public class ComentarioRepositorioJPA implements Comentario{
	private EntityManager entityManager;

	//get-set
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//methods
	public Comentario findOne(int numero) {
		return entityManager.find(Comentario.class, numero);
	}

	public Iterable<Comentario> findAll() {
		return entityManager.createQuery("SELECT c FROM Comentario c").getResultList();
	}

	public void save(Comentario comentario) {
		entityManager.persist(comentario);
		
	}

	public void delete(Comentario comentario) {
		entityManager.remove(comentario);
	}
	
}
