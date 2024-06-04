package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.Animal;

public interface AnimalService {
	
	List<Animal> animales(); // GET -> Lista de animales
	Optional<Animal> mostrarDatos(String codAnimal); // GET -> Mostrar datos de un animal a partir de su código
	List<Animal> enfermos(boolean enfermedad); // GET -> Mostrar animales enfermos
	public void addAnimal(Animal a); // POST -> Inscribir nuevo animal
	public void liberarAnimal(String codAnimal); // DELETE -> Libera a un animal a partir de su código
	public String curarAnimal(String codAnimal); // PUT / PATCH -> Actualiza el estado de un animal (si está enfermo, lo cura y muestra un mensaje)
}
