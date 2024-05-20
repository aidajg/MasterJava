package com.curso.dominio;

import jakarta.persistence.Entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "alumnos")

@NamedQueries({

		@NamedQuery(name = "buscarTodos", query = "SELECT a FROM Alumno a"),
		@NamedQuery(name = "buscarPorId", query = "SELECT a FROM Alumno a WHERE a.id = :id"),
		@NamedQuery(name = "buscarPorNombre", query = "SELECT COUNT(a.nombre), a.nombre FROM Alumno a WHERE a.nombre = :nombre"),
		@NamedQuery(name = "buscarPorApellido", query = "SELECT COUNT(a.apellido),a.apellido FROM Alumno a WHERE a.apellido = :apellido")
})
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String curso;

	// vacío
	public Alumno() {
	}

	// constructor
	public Alumno(int id, String nombre, String apellido, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
	}

	// getter&setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Alumno other = (Alumno) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
