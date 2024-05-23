package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursoDAO;
import com.curso.modelo.Curso;

@Service
//Declarar como un servicio
public class CursoServiceImpl implements CursoService{
	@Autowired
	//inyección del DAO
	CursoDAO dao;
	
	@Override
	public void altaCurso(Curso curso) {
		dao.save(curso);
	}

	@Override
	public void updateDuracion(int codCurso, int duracion) {
		dao.findById(codCurso).ifPresent(c -> c.setDuracion(duracion));
	}

	@Override
	public Curso buscarCurso(int codCurso) {
		return dao.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> deleteCurso(int codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public Curso buscarPorPvp(int minimo, int maximo) {
		return dao
				.findAll()
				.stream()
				.filter(c -> c.getPrecio() > minimo & c.getPrecio() < maximo)
				.findAny()
				.orElse(null);
	}

}
