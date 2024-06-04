package com.curso.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animales")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_Animal", unique= true)
	private String codAnimal;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "edad")
	private int edad; // Si edad >= 5 entonces citas anuales = 6 | Si edad >= 10 entonces citas
						// anuales = 12.

	@Column(name = "enfermedad")
	private boolean enfermedad; // Si true, añadir al veterinario

	@Column(name = "vacunas")
	private int vacunas; // Si < 6, añadir al veterinario

	@Column(name = "citas_vet")
	private int citasVeterinario = 0; // empiezan en cero


	// getters & setters
	public String getCodAnimal() {
		return codAnimal;
	}

	public void setCodAnimal(String codAnimal) {
		this.codAnimal = codAnimal;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(boolean enfermedad) {
		this.enfermedad = enfermedad;
	}

	public int getVacunas() {
		return vacunas;
	}

	public void setVacunas(int vacunas) {
		this.vacunas = vacunas;
	}

	public int getCitasVeterinario() {
		return citasVeterinario;
	}

	public void setCitasVeterinario(int citasVeterinario) {
		this.citasVeterinario = citasVeterinario;
	}

	// constructor vacío
	public Animal() {
		super();
	}

	// constructor con pk
	public Animal(String codAnimal) {
		super();
		this.codAnimal = codAnimal;
	}

	// constructor completo
	public Animal(String codAnimal, String tipo, String nombre, String sexo, int edad, boolean enfermedad, int vacunas) {
		super();
		this.codAnimal = codAnimal;
		this.tipo = tipo;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.enfermedad = enfermedad;
		this.vacunas = vacunas;
	}
	
	
	//HashCode - Equals (Mismo codigo = mismo animal)
	@Override
	public int hashCode() {
		return Objects.hash(codAnimal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(codAnimal, other.codAnimal);
	}

	
}
