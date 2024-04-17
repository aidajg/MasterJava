package ejercicios.coche;

public class Coche extends Vehiculo implements conducible{
	/**
	 * Tendrá varios atributos mutables (color), inmutables (matrícula) e inherentes (ruedas)
	 * La matrícula no se podrá cambiar una vez instanciado, y el número de ruedas no se podrán cambiar ni al instanciarlo.
	 */
	protected static int num_ruedas = 4;
	
	//constructor del padre
	public Coche(String matricula, String marca, String modelo, String color, int litros, int kilometraje, int precio) {
		super(matricula, marca, modelo, color, litros, kilometraje, precio);
	}
	
	
	//Métodos de la clase
	@Override
	public void conducir(int km){
		System.out.println(getMarca() + " recorre " + km + " km. ");
	}

	@Override
	public void acelerar(int km) {
		System.out.println(" >>> 🚗 Acelera " + km + " km. ");
		
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
		
		System.out.println("💧 Capacidad máxima: " + MAX + "L. Quieres llenar con " + L + " litros...");
		if(L > MAX) {
			resto = L - MAX;
			System.out.println("Sobrepasa el máximo. Sobran -> " + resto + " litros.");
		}else if(deposito == MAX) {
			System.out.println("💧 Depósito lleno.");
		}else if( L < MAX) {
			resto = MAX - L;
			deposito += L;
			System.out.println("💧 Llenando el depósito con " + L + " litros.");
			System.out.print("Litros en depósito -> " + deposito + ". ");
			
		}
	}
	
	//getter
	public void getNumRuedas() {
		System.out.println("Número de ruedas : " + num_ruedas);
	}

}
