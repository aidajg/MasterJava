package com.curso.repositorio.jpa;

import com.curso.repositorio.Departamento;

import jakarta.persistence.EntityManager;


public class DepartamentoRepositorioJPA implements Departamento{
	private EntityManager entityManager;
	
	//get-set
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//methods
	public Departamento findOne(int id) {
		return entityManager.find(Departamento.class, id);
	}

	public Iterable<Departamento> findAll() {
		return entityManager.createQuery("SELECT d FROM Departamento d").getResultList();
	}

	public void save(Departamento departamento) {
		entityManager.persist(departamento);
	}

	public void delete(Departamento departamento) {
		entityManager.remove(departamento);
	}

	

}
