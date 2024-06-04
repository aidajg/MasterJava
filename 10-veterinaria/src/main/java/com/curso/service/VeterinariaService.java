package com.curso.service;

import java.util.List;

import com.curso.model.Veterinaria;

public interface VeterinariaService {

	List<Veterinaria> veterinarias(boolean disponibilidad); // GET
	List<Veterinaria> precioLimite(int precio); // GET
	public void updateDisponibilidad(String nombreVet, boolean disponibilidad); // PATCH 
}
