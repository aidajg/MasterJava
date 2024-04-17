 package ejercicios.electrodomesticos;

public class Television extends Electrodomestico{
	//atributos
	protected static int pulgadas = 20;
	protected static boolean sintonizador = false;
	
	//constructor por defecto
	public Television() {
		
	}
	
	//constructor precio + peso
	public Television(int precioBase, int peso) {
		super(precioBase, peso);
	}

	//constructor con todo
	public Television(int precioBase, Color color, ConsumoEnergetico cs, int peso, int pulgadas, boolean sintonizador) {
		super(precioBase, color, cs, peso);
		this.pulgadas = pulgadas;
		this.sintonizador = sintonizador;
	}

	//getter
	public int getPulgadas() {
		return pulgadas;
	}
	public static boolean isSintonizador() {
		return sintonizador;
	}

	
	/**
	 * Calcular el precio final de acuerdo a la resolución y sintonizador.
	 */
	@Override
	public int precioFinal() {
		int precio = this.precioBase;
		int resolucion = this.pulgadas;
		boolean sintonizador = this.sintonizador;

		if(resolucion > 40) {
			precio *= 1.3;
		}
		
		if(sintonizador == true) {
			precio += 50;
		}
		return precio;
		
	}
	
}
