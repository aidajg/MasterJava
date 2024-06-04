package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Adopcion;
import com.curso.service.AdopcionService;


@RestController
public class AdopcionController {

	@Autowired
	AdopcionService service;
	
	/**
	 * Obtener las vacunas realizadas al animal según el código pasado como parámetro
	 * @param codAnimal -> Se buscará en la base de datos
	 * @return -> Si todo OK, genera la respuesta String mostrando las vacunas realizadas.
	 */
	@GetMapping(value="vacunas/{codAnimal}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getVacunasRealizadas(@PathVariable String codAnimal) {
		String resultado = service.vacunasRealizadas(codAnimal);
		return ResponseEntity.ok(resultado);
	}
	
	/**
	 * Listar todas las adopciones existentes
	 * @return -> Lista
	 */
	@GetMapping(value="adopciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Adopcion> adopciones(){
		return service.adopciones();
	}
	
	/**
	 * Realizar la adopción a través de Body (JSON)
	 * @param a -> Si los datos no respetan los registros reales de "animales" o "veterinarias", no se creará la adopción.
	 */
	@PostMapping(value="adoptar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void adoptar(@RequestBody Adopcion a){
		service.adoptar(a);
	}
}

