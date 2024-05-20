package com.curso.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="peliculas")
public class Pelicula {
	//Señalar a la clave primaria --> código
	@Id
	public int codigo;
	
	public String titulo;
	public String director;
	public int pvp;
	
	//constructor vacío
	public Pelicula() {
		
	}
	
	//constructor
	public Pelicula(int codigo, String titulo, String director, int pvp) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.director = director;
		this.pvp = pvp;
	}

	//get&set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getPvp() {
		return pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}


	//equals & hasCode (codigos son iguales)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
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
		Pelicula other = (Pelicula) obj;
		if (codigo != other.codigo)
			return false;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
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
		return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", director=" + director + ", pvp=" + pvp + "]";
	}
	
	
}
