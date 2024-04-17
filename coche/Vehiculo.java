package ejercicios.coche;

public abstract class Vehiculo {
	// atributos generales (vehículos)
	protected final String matricula; // -> inmutable

	protected String marca;
	protected String modelo;
	protected String color;
	protected int litros;
	protected int kilometraje;
	protected int precio;

	// atributos específicos (clase caballo)
	protected String raza;
	protected int peso;

	
	/**
	 * Matrícula parámetro final (relevante para Coche y Camión)
	 * @param matricula
	 */
	public Vehiculo(String matricula) {
		this.matricula = matricula;
	}

	// constructor (coche - camión)
	public Vehiculo(String matricula, String marca, String modelo, String color, int litros, int kilometraje, int precio) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.litros = litros;
		this.kilometraje = kilometraje;
		this.precio = precio;
	}

	// constructor (caballo)
	public Vehiculo(String raza, String color, int peso, int kilometraje, int precio) {
		this.matricula = null; //-> carece de matrícula
		this.raza = raza;
		this.color = color;
		this.peso = peso;
		this.kilometraje = kilometraje;
		this.precio = precio;
	}

	// constructor (bicicleta)
	public Vehiculo(String marca, String modelo, String color, int precio) {
		this.matricula = null; //-> carace de matrícula
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
	}


	/**
	 * Método cambiar el color del coche
	 * 
	 * @param color nuevo
	 */
	public void cambiarColor(String colornuevo) {
		String colorActual = this.color;
		System.out.println("El color actual es " + colorActual + ", cambiará a " + colornuevo + "...");
		colorActual = colornuevo;
		if (!colorActual.equals(colornuevo)) {
			System.out.println("No se ha podido pintar de " + colornuevo + ". Inténtalo de nuevo.");
		} else {
			System.out.println("Pintura exitosa! Tu " + getMarca() + " ahora es " + colornuevo + ".");
		}
	}

	/**
	 * Método para elegir un destino disponible
	 * 
	 * @param destino escogido
	 */
	public void elegirDestino(Destino d) {
		switch (d) {
		case CASA:
			System.out.println("Destino escogido -> " + d+ ", a una distancia de " + d.km + " km.");
			//-> llamar al método tacómetro para imprimir las velocidades alcanzadas en el trayecto
			break;
		case TRABAJO:
			System.out.println("Destino escogido -> " + d + ", a una distancia de " + d.km + " km.");
			break;
		case CENTRO:
			System.out.println("Destino escogido -> " + d + ", a una distancia de " + d.km + " km.");
			break;
		case AFUERAS:
			System.out.println("Destino escogido -> " + d + ", a una distancia de " + d.km + " km.");
			break;

		default:
			System.out.println("No se ha escogido ningun destino.");
			break;
		}
	}

	// métodos abstractos
	protected abstract void conducir(int km);

	protected abstract void acelerar(int km);

	protected abstract void llenarDeposito(int L);

	protected abstract void retroceder(int m);

	// get&set
	public String getMatricula() {
		return matricula;
	} // -> solamente se podrá recuperar

	public String getRaza() {
		return raza;
	} // -> solamente se podrá recuperar

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLitros() {
		return litros;
	}

	public void setLitros(int litros) {
		this.litros = litros;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
