package ejercicios.cafetera;

public class Cafetera {
	protected int capacidadMax;
	protected int cantidadActual;
	
	//cafetera vacía
	public Cafetera() {
		super();
		this.capacidadMax = 1000;
		this.cantidadActual = 0;
	}
	
	//cafetera llena
	public Cafetera(int capacidadMax) {
		this.cantidadActual = capacidadMax;
	}
	
	//ajustar cafetera
	public Cafetera(int capacidadMax, int cantidadActual) {
		if(cantidadActual > capacidadMax) {
			capacidadMax = 1000;
		}
	}

	//get&set
	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
		System.out.println("Cantidad actual:" + cantidadActual + "gr.");
	}
	
	//métodos
	public void llenar() {
		System.out.println("\n+++Se llena la cafetera.");
		setCantidadActual(getCapacidadMax());
	}
	
	public void servirTaza(int cafe) {
		System.out.println("\n***Sirviendo " + cafe + " de café en la taza***");
		if(getCantidadActual() < cafe) {
			System.out.println("No hay suficiente café en la cafetera, la taza se llenará con " + getCantidadActual());
		}else if(getCantidadActual() > cafe) {
			int resto = getCantidadActual() - cafe;
			System.out.println("La taza se llenará con " + cafe + "☕");
			setCantidadActual(resto);
		}else {
			System.out.println("La taza se llenará con lo que queda en la cafetera.");
		}
	}
	
	public void vaciar() {
		System.out.println("\n---Vaciando la cafetera.");
		setCantidadActual(0);
	}
	
	public void agregarCafe(int gramos) {
		System.out.println("\n+++Agregando " + gramos + " gramos a la cafetera.");
		if((getCantidadActual() + gramos) > getCapacidadMax()) {
			System.out.println("No se puede añadir, capacidad máxima alcanzada.");
		}else {
			setCantidadActual(gramos);
		}
	}
	
	
}
