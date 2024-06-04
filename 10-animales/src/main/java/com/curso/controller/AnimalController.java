package com.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Animal;
import com.curso.service.AnimalService;

@RestController
public class AnimalController {

	@Autowired
	AnimalService service;
	
	/**
	 * Listar animales registrados en la protectora de animales
	 * @return -> Lista
	 */
	@GetMapping(value="animales", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Animal> curso(){
		return service.animales();
	}
	
	
	/**
	 * Mostrar datos de un animal específico según su código (parámetro)
	 * @param codAnimal -> Busca en la base de datos
	 * @return -> Devuelve un animal
	 */
	@GetMapping(value="animal/{codAnimal}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<Animal> mostrarDatos(@PathVariable("codAnimal") String codAnimal){
		return service.mostrarDatos(codAnimal);
	}
	
	
	/**
	 * Mostrar animales con enfermedad (true) o sanos (false) en función del parámetro especificado
	 * @param enfermedad (true o false)
	 * @return -> Lista
	 */
	@GetMapping(value="enfermo/{enfermedad}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Animal> enfermos(@PathVariable("enfermedad") boolean enfermedad){
		return service.enfermos(enfermedad);
	}
	
	
	/**
	 * Inscribir a un nuevo animal en la protectora de animales a través de Body (JSON)
	 * @param a -> El body JSON
	 */
	@PostMapping(value="inscribir", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addAnimal(@RequestBody Animal a){
		service.addAnimal(a);
	}
	
	
	/**
	 * Liberar a un animal de la base de datos de la protectora de animales
	 * @param codAnimal -> Busca en la base de datos
	 */
	@DeleteMapping(value="liberar/{codAnimal}")
	public void liberarAnimal(@PathVariable("codAnimal") String codAnimal){
		service.liberarAnimal(codAnimal);
	}
	
	
	/**
	 * Actualizar el estado de un animal de enfermo a sano (Si enfermedad = true, será false) y mostrar mensaje.
	 * Si el animal ya estuviera sano, mostrará un mensaje.
	 * 
	 * @param codAnimal
	 * @return -> Lanza un mensaje (String) "ya está sano"
	 */
	@PatchMapping(value="curar/{codAnimal}")
	public String curarAnimal(@PathVariable("codAnimal") String codAnimal) {
		return service.curarAnimal(codAnimal);
	}
}
