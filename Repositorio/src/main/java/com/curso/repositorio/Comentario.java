package com.curso.repositorio;

public interface Comentario {
	public Comentario findOne(int numero);
	public Iterable<Comentario> findAll();
	public void save(Comentario comentario);
	public void delete(Comentario comentario);
}
