package com.curso.model;

public enum Tipo {

//Tipo de producto -> $ min. - max.
	ELECTRODOMÉSTICO(500, 1500), MUEBLE(200, 1200), TECNOLÓGICO(20, 3200), TÉXTIL(10, 80), DEPORTE(100, 2000);

	private int pvpMinimo;
	private int pvpMaximo;

	Tipo(int pvpMinimo, int pvpMaximo) {
		this.setPvpMinimo(pvpMinimo);
		this.pvpMaximo = pvpMaximo;
	}

	public int getPvpMaximo() {
		return pvpMaximo;
	}

	public void setPvpMaximo(int pvpMaximo) {
		this.pvpMaximo = pvpMaximo;
	}

	public int getPvpMinimo() {
		return pvpMinimo;
	}

	public void setPvpMinimo(int pvpMinimo) {
		this.pvpMinimo = pvpMinimo;
	}

}
