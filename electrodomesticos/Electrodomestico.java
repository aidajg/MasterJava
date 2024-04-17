package ejercicios.electrodomesticos;

public class Electrodomestico {
	//atributos (constantes)
	protected static int precioBase = 100;
	protected static Color color = Color.BLANCO;
	protected static ConsumoEnergetico cs = ConsumoEnergetico.F;
	protected static int peso = 5;
	
	//constructor por defecto
	public Electrodomestico() {
	}
	
	//constructor con precio + peso
	public Electrodomestico(int precioBase, int peso) {
		this.precioBase = precioBase;
		this.peso = peso;
	}

	
	//constructor con todos los atributos
	public Electrodomestico(int precioBase, Color color, ConsumoEnergetico cs, int peso) {
		this.precioBase = precioBase;
		this.color = color;
		this.cs = cs;
		this.peso = peso;
	}

	//getters
	public double getPrecioBase() {
		return precioBase;
	}

	public Color getColor() {
		return color;
	}

	public ConsumoEnergetico getCs() {
		return cs;
	}

	public double getPeso() {
		return peso;
	}
	
	 
	/**
	 * Métodos
	 * @param letra que se va a comprobar
	 */
	public void comprobarConsumoEnergético(ConsumoEnergetico letra) {
		ConsumoEnergetico letraCorrecta = this.cs;
		if(letra != letraCorrecta) {
			letraCorrecta = ConsumoEnergetico.F;
			System.out.println("Letra incorrecta. Se usará por defecto: " + ConsumoEnergetico.valueOf("F"));
		}else {
			letraCorrecta = letra;
		}
	}
	
	/**
	 * 
	 * @param color que se va a comprobar
	 */
	public boolean comprobarColor(Color color) {
		Color colorCorrecto = this.color;
		
		if(!color.equals(colorCorrecto)) {
			colorCorrecto = Color.BLANCO;
			System.out.println("Color incorrecto. Se usará por defecto: " + getColor());
			return false;
		}else {
			System.out.println("Color correcto! " + colorCorrecto);
			return true;
		}
	}
	
	/**
	 * Calcular el precio según el consumo energético
	 * @param letra
	 */
	public int precioFinal() {
		int precio = this.precioBase;
		int tamaño = calcularTamaño();
		
		switch (this.cs) {
		case A:
			precio += (100 + tamaño);
			System.out.println("El precio final es: " + precio);
			break;
		case B:
			precio += (80 + tamaño);
			System.out.println("El precio final es: " + precio);
			break;
		case C:
			precio += (60 + tamaño);
			System.out.println("El precio final es: " + precio);
			break;
		case D:
			precio += (50 + tamaño);
			System.out.println("El precio final es: " + precio);
			break;
		case E:
			precio += (30 + tamaño);
			System.out.println("El precio final es: " + precio);
			break;
		case F:
			precio += (10 + tamaño);
			System.out.println("El precio final es: " + precio);
			break;
		
		default:
			break;
		}
		return precio;
	}
	
	/**
	 * Función para calcular precio según el tamaño
	 * @return devuelve el precio después de pasar las comprobaciones de tamaño
	 */
	public int calcularTamaño() {
		int tamaño = this.peso;
		int añadir = 0;
		
		if(tamaño > 0 && tamaño <= 19) {
			añadir = 10;
		}else if(tamaño >= 20 && tamaño <= 49) {
			añadir = 50;
		}else if(tamaño >= 50 && tamaño <= 79) {
			añadir = 80;
		}else if(tamaño >= 80) {
			añadir = 100;
		}
		return añadir;
	}
	
}

