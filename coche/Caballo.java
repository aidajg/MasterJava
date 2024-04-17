package ejercicios.coche;

public class Caballo extends Vehiculo implements conducible{

	public Caballo(String raza, String color, int peso, int kilometraje, int precio) {
		super(raza, color, peso, kilometraje, precio);
	}

	//Métodos (sobreescribir)
	@Override
	public void conducir(int km) {
		System.out.println(getRaza() + " camina " + km + " km.");
		
	}

	@Override
	public void acelerar(int km) {
		System.out.println(" >>> 🐎 Galopa " + km + " km. ");
		
	}

	@Override
	public void retroceder(int m) {
		System.out.println(getRaza() + " ↩ Retrocede " + m + " m.");
		
	}

	@Override
	public void frenar() {
		System.out.println(getRaza() + " se ha parado.");
		
	}

	@Override
	public void llenarDeposito(int L) {
		final int MAX = 75;
		int vejiga = 0;
		int resto = 0;
		
		if(L > MAX) {
			resto = L - MAX;
			System.out.println("💧 Dándole de beber " + L + " litros de agua...");
			System.out.println("La capacidad máxima de " + getRaza() + " son " + MAX + " litros. Sobran " + resto + " litros que no beberá.");
		}else if(vejiga == MAX) {
			System.out.println("💧 " + getRaza() + " está lleno, no quiere beber más.");
		}else if( L < MAX) {
			resto = MAX - L;
			vejiga += L;
			System.out.println("💧 " + getRaza() + " bebe " + L + " litros de agua. Aún puede beber " + resto + " litros más.");
		}
		
		
		
	}

}
