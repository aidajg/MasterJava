package ejercicios.electrodomesticos;

public class Lavadora extends Electrodomestico{
	//atributo individual (constante)
	protected static int carga = 5;
	
	//constructor por defecto
	public Lavadora() {
		
	}
	
	//constructor precio + peso
	public Lavadora(int precioBase, int peso) {
		super(precioBase, peso);
	}
	
	//constructor con carga + heredados
	public Lavadora(int precioBase, Color color, ConsumoEnergetico cs, int peso, int carga) {
		super(precioBase, color, cs, peso);
		this.carga = carga;
	}

	//getter
	public static int getCarga() {
		return carga;
	}


	/**
	 * Calcular el precio Final según la carga
	 * @param carga
	 */
	@Override
	public int precioFinal() {
		int precio = this.precioBase;
		int carga = this.carga;
		
		if(carga > 30) {
			precio += 50;
		}
		return precio;
	}
	
	
}
