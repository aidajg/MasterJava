package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Adopcion;
import com.curso.model.Animal;

public interface AdopcionDao extends JpaRepository<Adopcion, Integer> {

}
