package ejercicios.animal;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	
public static void main(String[] args) {
	
	//Instanciar en una colección
	List<Animal> animales = new ArrayList<>();
	animales.add(new Gato());
	animales.add(new Araña());
	animales.add(new Pez());
	
	//instanceof (setear numpatas por cada instancia)
	for(Animal animal : animales) {
		if(animal instanceof Gato) {
			Gato gato = (Gato) animal;
			gato.setNumpatas(4);
		}else if(animal instanceof Araña) {
			Araña araña = (Araña) animal;
			araña.setNumpatas(8);
		}else if(animal instanceof Pez) {
			Pez pez = (Pez) animal;
			pez.setNumpatas(0);
		}
	}
	
	
	for (Animal animal : animales) {
		System.out.println(">>>");
		animal.comer();
		animal.andar();
		animal.jugar();
		System.out.println("");
	}
	
	
}
}
