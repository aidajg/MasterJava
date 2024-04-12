package ejercicios.animal;

public class Araña extends Animal{
	public Araña(int numpatas) {
		super(numpatas);
	}

	/**
	 * Sobreescribe métodos del padre
	 */
	@Override
	public void comer() {
		System.out.println("Las arañas comen mosquitos.");
	}

	
}
