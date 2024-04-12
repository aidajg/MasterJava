package ejercicios.figuras;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		//Interface List (colección)
		List <Figura> figuras = new ArrayList <>();
		figuras.add(new Cuadrado("Cuadrado"));
		figuras.add(new Círculo("Círculo"));
		figuras.add(new Rectángulo("Rectángulo"));
		
		for(Figura figura : figuras) {
			if(figura instanceof Cuadrado) {
				System.out.println(">>> " + figura.getNombre());
				((Cuadrado) figura).calcularArea(2);
				((Cuadrado) figura).calcularPerimetro(2);
			}else if(figura instanceof Rectángulo) {
				System.out.println("\n>>> " + figura.getNombre());
				((Rectángulo) figura).calcularArea(6,4);
				((Rectángulo) figura).calcularPerimetro(4,5);
			}else if(figura instanceof Círculo) {
				System.out.println("\n>>> " +  figura.getNombre());
				((Círculo) figura).calcularArea(5);
				((Círculo) figura).calcularPerimetro(5);
			}
		}
	}

}
