package com.curso.repositorio;

public interface Empleado {
	public Empleado findOne(int numero);
	public Iterable<Empleado> findAll();
	public void save(Empleado empleado);
	public void delete(Empleado empleado);
}
