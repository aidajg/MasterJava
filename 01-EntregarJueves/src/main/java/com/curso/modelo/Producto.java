package com.curso.modelo;

import java.util.ArrayList;

public class Producto {
	//atributos
	String nombre;
	String categoria;
	Double pvp;
	int stock;
	
	//construct
	public Producto(String nombre, String categoria, Double pvp, int stock) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.pvp = pvp;
		this.stock = stock;
	}

	//get&set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPvp() {
		return pvp;
	}

	public void setPvp(Double pvp) {
		this.pvp = pvp;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//toString
	@Override
	public String toString() {
		return "[" + nombre + "]<br>Categoria: " + categoria + "<br>Precio: " + pvp + "$<br>Stock: " + stock;
	}
	

}
