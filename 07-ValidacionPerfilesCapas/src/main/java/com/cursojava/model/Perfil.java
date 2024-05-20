package com.cursojava.model;

public class Perfil {
	private String nombre;
	private String password;
	private String correo;
	private int edad;

	public Perfil(String nombre, String password, String correo, int edad) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.correo = correo;
		this.edad = edad;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
