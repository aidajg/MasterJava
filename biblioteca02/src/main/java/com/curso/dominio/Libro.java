package com.curso.dominio;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity

@NamedQueries({

		@NamedQuery(name = "listarLibros", query = "SELECT l FROM Libro l"),
		@NamedQuery(name = "buscarIlustrados", query = "SELECT count(l.categoria), l.categoria FROM Libro l WHERE l.categoria = :categoria")
})

@Table(name="libros")
public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	//Señalar a la clave primaria --> isbn
	@Id
	public String isbn;
	
	public String titulo;
	public String autor;
	public int pvp;
	
	@ManyToOne
	@JoinColumn(name="categoria")
	//Establecer la relación de cardinalidad con la variable tipo Categoría
	private Categoria categoria;
	
	//constructor vacío
	public Libro() {
	}
	
	//constructor
	public Libro(String isbn, String titulo, String autor, int pvp) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.pvp = pvp;
	}

	//get&set
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPvp() {
		return pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + pvp;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (pvp != other.pvp)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", pvp=" + pvp + ", categoria="
				+ categoria + "]";
	}
	
	
}
