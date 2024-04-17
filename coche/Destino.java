package ejercicios.coche;

public enum Destino {
	CASA(3), TRABAJO(10), CENTRO(1), AFUERAS(20), CENTROCOMERCIAL(6);

	protected int km;

	private Destino(int km) {
		this.km = km;
	}

	public int getKm() {
		return km;
	}

}
