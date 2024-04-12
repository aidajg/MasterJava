package ejercicios.animal;

public class Pez extends Animal implements Mascota{
	
	public Pez(int numpatas) {
		super(numpatas);
	}

	/**
	 * Sobreescribir los métodos de la clase padre
	 */
	@Override
	public void comer() {
		System.out.println("Los peces comen plancton.");
	}

	@Override
	public void jugar() {
		System.out.println("Estoy nadando.");
	}

	@Override
	public void andar() {
		System.out.print("En realidad no ando, nado.");
		super.andar();
	}
}
