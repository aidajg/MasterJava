package com.curso.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String nombre;
	
	private String localidad;
	
	/**
	 * Cardinalidad -> Un departamento tiene muchos empleados
	 * Cascade tipo (ALL) -> Eliminar todos los empleados si se elimina su departamento
	 */
	@OneToMany(mappedBy="nombre_departamento",cascade=CascadeType.ALL)
	private List<Empleado> empleados = new ArrayList<Empleado>();

	//constructor con clave primaria
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
	}

	//constructor vacío
	public Departamento() {
		super();
	}

	//constructor
	public Departamento(String nombre, String localidad) {
		super();
		this.nombre = nombre;
		this.localidad = localidad;
	}


	//get&set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(localidad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(localidad, other.localidad) && Objects.equals(nombre, other.nombre);
	}

}
