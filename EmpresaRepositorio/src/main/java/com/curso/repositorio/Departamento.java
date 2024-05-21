package com.curso.repositorio;

public interface Departamento {
	public Departamento findOne(int numero);
	public Iterable<Departamento> findAll();
	public void save(Departamento departamento);
	public void delete(Departamento departamento);
}
