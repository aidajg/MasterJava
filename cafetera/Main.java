package ejercicios.cafetera;

public class Main {
	public static void main(String[] args) {
		Cafetera cafetera = new Cafetera();
		cafetera.llenar();
		
		cafetera.servirTaza(250);
		
		cafetera.vaciar();
		
		cafetera.agregarCafe(500);
	}
}
