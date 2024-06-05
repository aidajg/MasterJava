package com.curso.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="veterinarias")
public class Veterinaria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nombre", unique = true)
	//primary key
	private String nombreVet;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="precio")
	private int precio;
	
	@Column(name="disponibilidad")
	private boolean disponibilidad;

	//getters&setters
	public String getNombreVet() {
		return nombreVet;
	}

	public void setNombreVet(String nombreVet) {
		this.nombreVet = nombreVet;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	
	//constructor vacío
	public Veterinaria() {
		super();
	}
	
	//constructor con pk
	public Veterinaria(String nombreVet) {
		super();
		this.nombreVet = nombreVet;
	}

	
	//constructor completo
	public Veterinaria(String nombreVet, String ciudad, int precio, boolean disponibilidad) {
		super();
		this.nombreVet = nombreVet;
		this.ciudad = ciudad;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
	}

	
	
	//HashCode - Equals (Mismo nombre = misma veterinaria)
	@Override
	public int hashCode() {
		return Objects.hash(nombreVet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veterinaria other = (Veterinaria) obj;
		return Objects.equals(nombreVet, other.nombreVet);
	}
	
}
