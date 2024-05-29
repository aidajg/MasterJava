package com.curso.model;

import java.util.Objects;

public class Pedido {
	private String nombre;
	private int stock;
	private Tipo tipo;
	private int pvp;
	
	public Pedido() {
		super();
	}

	public Pedido(String nombre, int stock, Tipo tipo, int pvp) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.tipo = tipo;
		this.pvp = pvp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public int getPvp() {
		return pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, pvp, stock, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(nombre, other.nombre) && pvp == other.pvp && stock == other.stock && tipo == other.tipo;
	}
	
	
}
