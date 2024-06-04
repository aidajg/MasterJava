package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Veterinaria;
import com.curso.service.VeterinariaService;

@RestController
public class VeterinariaController {
	
	@Autowired
	VeterinariaService service;
	
	/**
	 * Obtener una lista de veterinarias especificando la disponibilidad (true - false)
	 * @param disponibilidad (booleana)
	 * @return -> Lista
	 */
	@GetMapping(value="veterinarias/{disponibilidad}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Veterinaria> veterinarias(@PathVariable("disponibilidad")boolean disponibilidad){
		return service.veterinarias(disponibilidad);
	}
	
	/**
	 * Produce una lista de veterinarias que no sobrepasan el precio indicado.
	 * @param precio -> Es el precio límite
	 * @return -> Lista
	 */
	@GetMapping(value="precio/{precioLimite}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Veterinaria> precioLimite(@PathVariable("precioLimite")int precio){
		return service.precioLimite(precio);
	}
	
	/**
	 * Actualiza una veterinaria especificada por nombre, cambiando su disponibilidad (true - false)
	 * @param nombreVet -> Busca en la base de datos
	 * @param disponibilidad -> Cambia su valor
	 */
	@PatchMapping(value="disponibilidad/{nombreVet}/{disponibilidad}")
	public void curarAnimal(@PathVariable("nombreVet") String nombreVet, @PathVariable("disponibilidad") boolean disponibilidad) {
		 service.updateDisponibilidad(nombreVet, disponibilidad);
	}
}
