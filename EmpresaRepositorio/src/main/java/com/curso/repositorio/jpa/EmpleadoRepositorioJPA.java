package com.curso.repositorio.jpa;

import com.curso.repositorio.Empleado;

import jakarta.persistence.EntityManager;

public class EmpleadoRepositorioJPA implements Empleado{
	private EntityManager entityManager;

	//get-set
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	//methods
	public Empleado findOne(int id) {
		return entityManager.find(Empleado.class, id);
	}

	public Iterable<Empleado> findAll() {
		return entityManager.createQuery("SELECT e FROM Empleado e").getResultList();
	}

	public void save(Empleado empleado) {
		entityManager.persist(empleado);
	}

	public void delete(Empleado empleado) {
		entityManager.remove(empleado);
	}
	
}
