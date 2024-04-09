package ejercicios.herencia;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//Crear los electrodomésticos
		Electrodoméstico [] e = new Electrodoméstico[6];
		e[0] = new Lavadora("Lavadora (Siemens X80)", 208.99, 50);
		e[1] = new Batidora("Batidora (Roboto RT)", 140.60, 35);
		e[2] = new Cocina_de_gas("Cocina de gas (XG506)", 99.99, 20);
		e[3] = new Tocadiscos("Tocadiscos (Luis XIV)", 300.00, 18);
		e[4] = new ReproductorDeCassette("Cassette (Samsung A2)", 60.00, 25);
		e[5] = new ReproductorDeCD("Reproductor de CD (Lovoo 09)", 30.20, 27);
		
		//Usar métodos
		System.out.println(e[0].encender());
		
		System.out.println("\n'Me voy a hacer un zumo...' " + e[1].encender());
		
		System.out.println("\n'Ya ha terminado la lavadora...' " + e[0].apagar());
		
		System.out.println("\n'Quiero escuchar música mientras hago la comida.'");
		System.out.println(e[2].encender() + " y " + e[5].encender());
		
		System.out.println("\n'Oh no! " + e[5].getModelo() + " se ha estropeado. Menos mal que sólo me ha costado " + e[5].getPrecio() + " €.'");
		System.out.println(e[5].apagar() + " y " + e[4].encender());
		
		System.out.println("\n" + e[4].play() + ". Me gusta esta canción... " + e[4].rewind());
		
		
	}
}
