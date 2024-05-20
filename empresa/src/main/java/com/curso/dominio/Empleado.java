package com.curso.dominio;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity


@NamedQueries({

		@NamedQuery(name = "listarEmpleados", query = "SELECT e FROM Empleado e"),
		@NamedQuery(name = "buscarPorDept", query = "SELECT e FROM Empleado e WHERE e.id_departamento = :id"),
})

@Table(name="empleados")
public class Empleado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	private String fecha;
	private int sueldo;
	
	@OneToOne
	@JoinColumn(name="departamentos")
	//Carnalidad --> Un empleado solo puede trabajar en un departamento
	public Departamento id_departamento;

	
	//vacío
	public Empleado() {
		super();
	}

	
	//constructor
	public Empleado(int id, String nombre, String fecha, int i) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.sueldo = i;
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


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getSueldo() {
		return sueldo;
	}


	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}


	public Departamento getId_departamento() {
		return id_departamento;
	}


	public void setId_departamento(Departamento id_departamento) {
		this.id_departamento = id_departamento;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + sueldo;
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
		Empleado other = (Empleado) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sueldo != other.sueldo)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", sueldo=" + sueldo
				+ ", id_departamento=" + id_departamento + "]";
	}
	
	
}
