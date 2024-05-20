package com.curso.repositorio;

public interface Noticia {
	public Noticia findOne(String titulo);
	public Iterable<Noticia> findAll();
	public void save(Noticia noticia);
	public void delete(Noticia noticia);
}
