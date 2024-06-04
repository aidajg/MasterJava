package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.AdopcionDao;
import com.curso.dao.AnimalDao;
import com.curso.model.Adopcion;
import com.curso.model.Animal;

@Service
public class AdopcionServiceImpl implements AdopcionService{
	/**
	 *	Inyección de dependencias.
	 *	@Autowired --> Usa DAO de Animal para buscar el animal en la base de datos a través de su código (parámetro)
	 */
	@Autowired
	AdopcionDao dao;
	
	@Autowired
	AnimalDao animalDao;
	
	
	/**
	 * Obtener las vacunas realizadas a un animal específico, a través de su código.
	 * A través del AnimalDao, llamar al método personalizado "findByCodAnimal" para recuperar al animal.
	 * 
	 * @if -> Comprobar que dicho animal existe en la base de datos.
	 * @return -> Devuelve una respuesta String indicando varia información del registro
	 */
	@Override
	public String vacunasRealizadas(String codAnimal) {
		//Obtener las vacunas realizadas a través del codigo del animal

		//Buscar al animal en la base de datos, comprobar que existe
		Animal a = animalDao.findByCodAnimal(codAnimal);
		if( a != null) {
			return "Vacunas realizadas a " + a.getNombre() + " (" + a.getTipo() + "): " + a.getVacunas();
		}else {
			return "No existe el animal con código proporcionado.";
		}
	}

	
	/**
	 * Realizar el proceso de adopción
	 * Insercción de registros en la base de datos respetando las claves foráneas, referentes a "animales" y "veterinarias"
	 * 
	 * @trycatch -> Se intenta realizar la adopción. La propia base de datos rechazará el registro si el cógido del animal y la veterinaria proporcionados
	 * no existen en sus respectivas tablas. En caso de éxito, se generará la lista actualizada.
	 * En este momento, al animal se le asignará la veterinaria especificada.
	 */
	
	@Override
	public List<Adopcion> adoptar(Adopcion adop) {
		try {
			if(adop != null) {
				dao.save(adop);
				return dao.findAll();
			}
			
			System.out.print("Datos incorrectos, no se pudo adoptar.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dao.findAll();
		
	}

	/**
	 * Listar adopciones existentes
	 * @return -> Se genera la lista
	 */
	@Override
	public List<Adopcion> adopciones() {
		return dao.findAll();
	}

}
