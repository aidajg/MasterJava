package ejercicios.Orquesta;

public class Orquesta {
	public static void main(String[] args) {
		//crear los instrumentos
		Flauta fl = new Flauta("Flauta", "viento", "F-08");
		Guitarra gu = new Guitarra("Guitarra", "cuerda", 6);
		Guitarra_eléctrica el = new Guitarra_eléctrica("Guitarra eléctrica", "cuerda", 6, 25);
		Tambor tb = new Tambor("Tambor", "percusión", "40cm");
	
		//Comienza la secuencia de la orquesta

		System.out.println("\n***Se afinan los instrumentos...");
		gu.afinar();
		fl.afinar();
		el.afinar();
		
		System.out.println("\n***🎼 Empieza la música...");
		tb.aporrear();
		el.tocar();
		gu.tocar();
		fl.tocar();
	}
	
}
