package com.curso.service;

import java.util.List;

import com.curso.model.Adopcion;

public interface AdopcionService {

	List<Adopcion> adopciones(); // GET
	public String vacunasRealizadas(String codAnimal); // GET (ResponseEntity)
	public List<Adopcion> adoptar(Adopcion a); // POST
}
