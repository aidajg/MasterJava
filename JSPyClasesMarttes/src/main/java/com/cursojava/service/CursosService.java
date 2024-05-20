package com.cursojava.service;

import java.util.ArrayList;
import java.util.List;

import com.cursojava.modelo.Curso;

public class CursosService {
	
	public List<Curso> buscarTodos(){
		Curso c1 = new Curso("chino", 2);
		Curso c2 = new Curso("esperanto", 1);
		Curso c3 = new Curso("japones", 3);
		Curso c4 = new Curso("sueco", 1);
		
		List<Curso> listaCursos = new ArrayList<Curso>();
		listaCursos.add(c1);
		listaCursos.add(c2);
		listaCursos.add(c3);
		listaCursos.add(c4);
		
		return listaCursos;
	}
}
