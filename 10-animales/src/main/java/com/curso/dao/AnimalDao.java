package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Animal;

public interface AnimalDao extends JpaRepository<Animal, String> {
	
	/**
	 * Método personalizado para poder encontrar al animal por su código
	 * @param codAnimal
	 * @return
	 */
	 Animal findByCodAnimal(String codAnimal);
}
