package com.curso.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="adopciones")
public class Adopcion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="codigo", unique = true)
	//Primary Key Auto-Incremental
	private int idAdopcion;
	
	@Column(name="cliente")
	private String nombreCliente;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="cod_animal")
	private String codAnimal;
	
	@Column(name="nombre_vet")
	private String nombreVet;

	// getters & setters
	public int getIdAdopcion() {
		return idAdopcion;
	}

	public void setIdAdopcion(int idAdopcion) {
		this.idAdopcion = idAdopcion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodAnimal() {
		return codAnimal;
	}

	public void setCodAnimal(String codAnimal) {
		this.codAnimal = codAnimal;
	}

	public String getNombreVet() {
		return nombreVet;
	}

	public void setNombreVet(String nombreVet) {
		this.nombreVet = nombreVet;
	}

	//constructor vacío
	public Adopcion() {
		super();
	}
	
	//constructor con pk
	public Adopcion(int idAdopcion) {
		super();
		this.idAdopcion = idAdopcion;
	}

	//constructor completo
	public Adopcion(int idAdopcion, String nombreCliente, String dni, String codAnimal, String nombreVet) {
		super();
		this.idAdopcion = idAdopcion;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.codAnimal = codAnimal;
		this.nombreVet = nombreVet;
	}

	//HashCode - Equals (Mismo id = misma adopcion)
	@Override
	public int hashCode() {
		return Objects.hash(idAdopcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adopcion other = (Adopcion) obj;
		return idAdopcion == other.idAdopcion;
	}
	
	
	
}
