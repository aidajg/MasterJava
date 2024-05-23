package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.modelo.Curso;

/*
 * 1º Param --> Modelo
 * 2º Param --> Tipo de dato de la clave primaria
 */
public interface CursoDAO extends JpaRepository<Curso, Integer> {

}
