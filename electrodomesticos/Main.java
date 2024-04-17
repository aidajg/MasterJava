package ejercicios.electrodomesticos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		//array de electrodomésticos
		List<Electrodomestico> e = new ArrayList<>();
		Electrodomestico l1 = new Lavadora(450, 50);
		Electrodomestico l2 = new Lavadora(399, Color.AZUL, ConsumoEnergetico.B, 80, 40);
		Electrodomestico l3 = new Lavadora(299, Color.NEGRO, ConsumoEnergetico.D, 40, 20);
		
		Electrodomestico t1 = new Television();
		Electrodomestico t2 = new Television(1200, Color.GRIS, ConsumoEnergetico.F, 80, 60, false);
		Electrodomestico t3 = new Television(999, Color.BLANCO, ConsumoEnergetico.A, 75, 65, true);
		e.add(l1);
		e.add(l2);
		e.add(l3);
		e.add(t1);
		e.add(t2);
		e.add(t3);
		
		//Según la instancia --> ejecutar los métodos
		for(Electrodomestico objeto : e) {
			//Caso Lavadoras
			if(objeto instanceof Lavadora) {
				Lavadora lava = (Lavadora) objeto;
				System.out.println(">>> Su precio base es " + lava.getPrecioBase() + " euros, de color " + lava.getColor() + ", consumo energético tipo: " + lava.getCs() + ", pesa " + lava.getPeso() + "kg y puede cargar hasta " + lava.getCarga() + " kg.");
				
				lava.comprobarColor(Color.BLANCO);
				lava.precioFinal();
				System.out.println();
			}
			//Caso Televisiones
			if(objeto instanceof Television) {
				Television tv = (Television) objeto;
				System.out.println("\n>>> Su precio base es " + tv.getPrecioBase() + " euros, de color " + tv.getColor() + ", consumo energético tipo: " + tv.getCs() + ", pesa " + tv.getPeso() + "kg, " + tv.getPulgadas() + " pulgadas y sintonizador: " + tv.isSintonizador());
				
				tv.comprobarColor(Color.GRIS);
				tv.precioFinal();
				
			}
		}
	
	}
}
