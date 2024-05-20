package com.curso.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity


@NamedQueries({

		@NamedQuery(name = "listarDepartamentos", query = "SELECT d FROM Departamento d")
})

@Table(name="departamentos")
public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String nombre;
	private String localidad;
	
	//Lista de Empleados --> mapear por la variable id_departamento (clase Empleado)
	@OneToMany(mappedBy="id_departamento")
	//Carnalidad --> En un departamento trabajan muchos empleados
	private List<Empleado> empleados = new ArrayList<Empleado>();

	
	//vacío
	public Departamento() {
		super();
	}


	
	//constructor
	public Departamento(int id, String nombre, String localidad, List<Empleado> empleados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.localidad = localidad;
		this.empleados = empleados;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
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
		Departamento other = (Departamento) obj;
		if (id != other.id)
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + "]";
	}

	
}
