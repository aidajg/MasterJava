package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Ejemplar;
import com.curso.service.EjemplarService;


@RestController
public class EjemplarController {

	@Autowired
	EjemplarService service;
	
	@PostMapping(value="ejemplar/{isbn}/{titulo}/{tematica}", consumes= MediaType.APPLICATION_JSON_VALUE)
	List<Ejemplar> altaEjemplar(@PathVariable("isbn") int isbn, @PathVariable("titulo") String titulo , @PathVariable("tematica") String tematica){
		Ejemplar e = new Ejemplar(isbn, titulo, tematica);
		return service.nuevoEjemplar(e);
	}
	
}
