package com.curso.service;

import java.util.List;

import com.curso.modelo.Curso;

public interface CursoService {
	
	void altaCurso(Curso curso); // POST
	void updateDuracion(int codCurso, int duracion); // PUT
	Curso buscarCurso(int codCurso); // GET
	List <Curso> deleteCurso(int codCurso); // DELETE
	Curso buscarPorPvp(int minimo, int maximo); // GET
}
