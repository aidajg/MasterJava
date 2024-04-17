package ejercicios.coche;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Camion extends Vehiculo implements conducible {
	protected static int num_ruedas = 10;
	/**
	 * Atributo propio de la clase
	 * 
	 * @list -> se introducen los valores (ya declarados) de enum Destino
	 */
	public List<Destino> tacometro;
	
	public void calcularVelocidades() {
		//llenar el array de velocidades con 'supuestos' (máx 90km/h - min 45km/h)
		int [] velocidades = new int[15];
		int max = 90;
		int min = 45;
		
		for(int i = 0; i < velocidades.length; i++) {
				velocidades[i] = (int) (Math.random() * (max - min) + min);
			}
		System.out.println("Velocidades alcanzadas (km/h): " + Arrays.toString(velocidades));
		
	}
	
	
	// constructor heredado
	public Camion(String matricula, String marca, String modelo, String color, int litros, int kilometraje, int precio) {
		super(matricula, marca, modelo, color, litros, kilometraje, precio);
		this.tacometro = new ArrayList<>();
	}


	// Métodos de la clase
	@Override
	public void conducir(int km) {
		System.out.println(getMarca() + " conduce a " + km + " km/h ");
	}

	@Override
	public void acelerar(int km) {
		System.out.println(getMarca() + " >>> 🚚 Acelera " + km + " km. ");

	}

	@Override
	public void retroceder(int m) {
		System.out.println(getMarca() + " ↩ Retrocede " + m + " m.");
	}

	@Override
	public void frenar() {
		System.out.println(getMarca() + " está frenando...");

	}

	@Override
	public void llenarDeposito(int L) {
		final int MAX = getLitros();
		int deposito = 0;
		int resto = 0;

		System.out.println("Capacidad máxima: " + MAX + "L. Quieres llenar con " + L + " litros...");
		if (L > MAX) {
			resto = L - MAX;
			System.out.println("Sobrepasa el máximo. Sobran -> " + resto + " litros.");
		} else if (deposito == MAX) {
			System.out.println("💧 Depósito lleno.");
		} else if (L < MAX) {
			resto = MAX - L;
			deposito += L;
			System.out.println("💧 Llenando el depósito con " + L + " litros.");
			System.out.print("Litros en depósito -> " + deposito + ". ");

		}
	}
	
	/**
	 * Get&Set de propiedad tacometro -> con los valores de Destino (enum)
	 * @return
	 */
	public List<Destino> getTacometro() {
		return tacometro;
	}


	public void setTacometro(List<Destino> tacometro) {
		this.tacometro = tacometro;
	}

	//getter
	public void getNumRuedas() {
		System.out.println("Número de ruedas : " + num_ruedas);
	}

}
