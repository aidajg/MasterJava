package ejercicios.Orquesta;

public class Guitarra_eléctrica extends Guitarra {
	//atributos
	protected int potencia;
	
	//constructor
	public Guitarra_eléctrica(String nombre, String tipo, int num_cuerdas, int potencia) {
		super(nombre, tipo, num_cuerdas);
		this.potencia = potencia;
	}

	/**
	 * Sobreescribir, de nuevo, el método del padre
	 */
	@Override
	public void tocar() {
		System.out.println("🎸 Tocando la guitarra eléctrica.");
	}
	
	
}
