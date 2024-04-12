package ejercicios.animal;

public class Gato extends Animal implements Mascota{
	
	/**
	 * Sobreescribir los métodos de la clase padre
	 */
	@Override
	public void comer() {
		System.out.println("A los gatos les gusta comer peces y arañas.");
	}
	
	@Override
	public void jugar() {
		System.out.println("A " + nombre + " le gusta jugar con pelotas.");
	}
}
