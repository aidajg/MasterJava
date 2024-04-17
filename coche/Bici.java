package ejercicios.coche;

public class Bici extends Vehiculo implements conducible {
	
	protected static int num_ruedas = 2;
	
	// constructor del padre
	public Bici(String marca, String modelo, String color, int precio)  {
		super(marca, modelo, color, precio);
	}

	// Métodos de la clase
	@Override
	public void conducir(int km) {
		System.out.print(getMarca() + " recorre " + km + " km. ");
	}

	@Override
	public void acelerar(int km) {
		System.out.println(">>> 🚲 Acelera " + km + " km. ");

	}

	@Override
	public void retroceder(int m) {
		System.out.println(getMarca() + " ↩ Retrocede " + m + " m.");
	}

	@Override
	public void frenar() {
		System.out.println(getMarca() + " para.");

	}

	@Override
	public void llenarDeposito(int L) {
	} //-> No usable, la bici no se llena

	//getter
	public void getNumRuedas() {
		System.out.println("Número de ruedas : " + num_ruedas);
	}
}
