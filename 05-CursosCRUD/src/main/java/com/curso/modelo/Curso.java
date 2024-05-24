package com.curso.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
//Declarar como entidad
public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;
	//atributos
	@Id
	//pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codCurso;
	
	private String nombre;
	private int duracion;
	private double precio;
	
	//get&set
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//constructor vacío
	public Curso() {
		super();
	}
	
	//constructor con pk
	public Curso(int codCurso) {
		super();
		this.codCurso = codCurso;
	}
	
	//constructor con parámetros
	public Curso(int codCurso, String nombre, int duracion, double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codCurso, duracion, nombre, precio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return codCurso == other.codCurso && duracion == other.duracion && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}
	
	
	
	
}
