package com.curso.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Empleado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private LocalDate fecha;
	private int sueldo;
	
	/**
	 * Cardinalidad -> Un empleado pertenece a un departamento
	 * Tipo de carga (LAZY)
	 */
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nombre_departamento")
	public Departamento nombre_departamento;

	//constructor con clave primaria
	public Empleado(int id) {
		super();
		this.id = id;
	}

	//vacío
	public Empleado() {
		super();
	}

	
	//constructor
	public Empleado(String nombre, LocalDate fecha, int sueldo, Departamento nombre_departamento) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.sueldo = sueldo;
		this.nombre_departamento = nombre_departamento;
	}

	
	//get&set
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


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getSueldo() {
		return sueldo;
	}


	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}


	public Departamento getNombre_departamento() {
		return nombre_departamento;
	}

	public void setNombre_departamento(Departamento nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, nombre, sueldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(fecha, other.fecha) && id == other.id && Objects.equals(nombre, other.nombre)
				&& sueldo == other.sueldo;
	}

	
	
}
