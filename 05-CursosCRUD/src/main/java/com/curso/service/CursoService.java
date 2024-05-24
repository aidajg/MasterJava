package com.curso.service;

import java.util.List;

import com.curso.modelo.Curso;

public interface CursoService {
	List<Curso> cursos();
	void altaCurso(Curso curso); // POST
	void updateDuracion(int codCurso, int duracion); // PUT
	Curso buscarCurso(int codCurso); // GET
	List <Curso> deleteCurso(int codCurso); // DELETE
	List<Curso> buscarPorPvp(int minimo, int maximo); // GET
}
