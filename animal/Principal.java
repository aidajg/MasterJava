package ejercicios.animal;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		// Instanciar en una colección
		List<Animal> animales = new ArrayList<>();
		animales.add(new Gato(4));
		animales.add(new Araña(8));
		animales.add(new Pez(0));

		for (Animal animal : animales) {
			if (animal instanceof Araña) {
				System.out.println(">>>");
				animal.comer();
				animal.andar();
				System.out.println("");
			} else {
				System.out.println(">>>");
				animal.comer();
				animal.andar();
				animal.jugar();
				System.out.println("");
			}
		}

	}
}
