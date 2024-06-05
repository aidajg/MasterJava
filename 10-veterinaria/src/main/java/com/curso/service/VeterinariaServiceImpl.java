package com.curso.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.VeterinariaDao;
import com.curso.model.Veterinaria;

@Service
public class VeterinariaServiceImpl implements VeterinariaService{
	
	@Autowired
	VeterinariaDao dao;
	
	/**
	 * Devuelve una lista de veterinarias disponibles (o no) en función del parámetro
	 */
	@Override
	public List<Veterinaria> veterinarias(boolean disponibilidad) {
		return dao.findAll().stream()
				.filter(v -> v.isDisponibilidad() == disponibilidad)
				.collect(Collectors.toList());
	}

	/**
	 * Devuelve una lista de veterinarias cuyo precio no sobrepase el indicado como parámetro
	 */
	@Override
	public List<Veterinaria> precioLimite(int precio) {
		return dao.findAll().stream()
				.filter(v -> v.getPrecio() <= precio)
				.collect(Collectors.toList());
	}

	/**
	 * Actualiza la disponibilidad de la veterinaria especificada (true o false)
	 */
	@Override
	public void updateDisponibilidad(String nombreVet, boolean disponibilidad) {
		Veterinaria v = dao.findById(nombreVet).get();
		
		if(v != null) {
			v.setDisponibilidad(disponibilidad);
			dao.save(v);
		}
	}

}
