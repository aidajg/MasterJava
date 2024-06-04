package com.curso.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.AnimalDao;
import com.curso.model.Animal;

@Service
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	AnimalDao dao;

	/**
	 * Listar todos los animales
	 */
	@Override
	public List<Animal> animales() {
		return dao.findAll();
	}

	/**
	 * Mostrar los datos del animal especificado por código
	 */
	@Override
	public Optional<Animal> mostrarDatos(String codAnimal) {
		return dao.findById(codAnimal);
	}

	/**
	 * Devuelve una lista de animales enfermos (o no) en función del parámetro (true - false)
	 */
	@Override
	public List<Animal> enfermos(boolean enfermedad) {
		return dao.findAll().stream()
	               .filter(a -> a.isEnfermedad() == enfermedad)
	               .collect(Collectors.toList());
	}

	/**
	 * Inscribir un animal nuevo (body JSON) en la protectora de animales
	 */
	@Override
	public void addAnimal(Animal a) {
		dao.save(a);
	}
	
	/**
	 * Si enfermedad (true), pasará a false y mostrar mensaje.
	 * Si enfermedad (false), mostrar mensaje de que el animal ya está sano.
	 * 
	 * @contador -> Contabiliza las visitas al veterinario de cada animal si estos son curados de una enfermedad.
	 * @return -> Devuelve un mensaje (String)
	 */
	int contador = 0;
	
	@Override
	public String curarAnimal(String codAnimal) {
		Animal animal = dao.findById(codAnimal).get(); //buscar por id y conseguir su clase
		
		if(animal != null) {
			if(animal.isEnfermedad() == true){ //Si está enfermo (true)
				animal.setEnfermedad(false); //Lo cura y muestra mensaje de éxito
				contador++; //por cada vez que se cura a un animal, se suman sus citas al veterinario
				animal.setCitasVeterinario(contador);
				dao.save(animal);
				return "Animal " + animal.getTipo() + " (" + animal.getNombre() + ") está curado!";
			}else if(animal.isEnfermedad() == false) { //Si no está enfermo (false)
				return "Animal " + animal.getTipo() + " (" + animal.getNombre() + ") no está enfermo.";
			}
		}
		return codAnimal;
	}

	/**
	 * Se libera a un animal de la protectora
	 */
	@Override
	public void liberarAnimal(String codAnimal) {
		dao.deleteById(codAnimal);
	}
	

}
