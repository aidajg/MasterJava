package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Entity;

public class Producto {
	private int codigo;
	private String nombre;
	private int stock;
	private boolean garantia;
	private Tipo tipo;
	private int pvp;

	public Producto() {
		super();
	}

	public Producto(int codigo, String nombre, int stock, boolean garantia, Tipo tipo, int pvp) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
		this.garantia = garantia;
		this.tipo = tipo;
		this.pvp = pvp;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isGarantia() {
		return garantia;
	}

	public void setGarantia(boolean garantia) {
		this.garantia = garantia;
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
		return Objects.hash(codigo, stock, garantia, nombre, pvp, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo && Objects.equals(stock, other.stock) && garantia == other.garantia
				&& Objects.equals(nombre, other.nombre) && pvp == other.pvp && tipo == other.tipo;
	}

	/**
	 * Devuelve los límites máximos y mínimos (pvp) de cada producto según su tipo
	 */
	@Override
	public String toString() {
		return "\tTIPO (" + tipo + ") = pvp mínimo --> $" + tipo.getPvpMinimo() + "| pvp máximo --> $"
				+ tipo.getPvpMaximo() + "\n";
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
