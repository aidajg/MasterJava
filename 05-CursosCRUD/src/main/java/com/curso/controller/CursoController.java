package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.Curso;
import com.curso.service.CursoService;

@RestController
public class CursoController {
	@Autowired
	CursoService service;
	
	//Mostrar todos los cursos
	@GetMapping(value="cursos", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos(){
		return service.cursos();
	}
	
	//Dar de alta un curso -> JSON
	@PostMapping(value="cursos", consumes= MediaType.APPLICATION_JSON_VALUE)
	void altaCurso(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
	//Actualizar un curso -> codCurso y duracion (Se actualiza la duracion, no devuelve datos)
	@PutMapping(value="cursos/{codCurso}/{duracion}", consumes= MediaType.APPLICATION_JSON_VALUE)
	void updateDuracion(@PathVariable("codCurso") int codCurso, @PathVariable("duracion") int duracion) {
		service.updateDuracion(codCurso, duracion);
	}
	
	//Buscar un curso -> JSON
	@GetMapping(value="cursos/{codCurso}", produces= MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("codCurso") int codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	//Buscar un curso por precio -> JSON
	@GetMapping(value="cursos/{minimo}/{maximo}", produces= MediaType.APPLICATION_JSON_VALUE)
	public List <Curso> buscarPorPvp(@PathVariable("minimo") int minimo, @PathVariable("maximo") int maximo) {
		return service.buscarPorPvp(minimo, maximo);
	}

	//Eliminar un curso -> JSON
	@DeleteMapping(value="cursos/{codCurso}", produces= MediaType.APPLICATION_JSON_VALUE)
	public List <Curso> deleteCurso(@PathVariable("codCurso") int codCurso){
		return service.deleteCurso(codCurso);
	}
}
