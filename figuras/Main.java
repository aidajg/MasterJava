package ejercicios.figuras;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		//Interface List (colección)
		List <Figura> figuras = new ArrayList <>();
		figuras.add(new Cuadrado());
		figuras.add(new Círculo());
		figuras.add(new Rectángulo());
		
		for(Figura figura : figuras) {
			if(figura instanceof Cuadrado) {
				System.out.println(">>> Cuadrado");
				((Cuadrado) figura).calcularArea(2);
				((Cuadrado) figura).calcularPerimetro(2);
			}else if(figura instanceof Rectángulo) {
				System.out.println("\n>>> Rectángulo");
				((Rectángulo) figura).calcularArea(6,4);
				((Rectángulo) figura).calcularPerimetro(4,5);
			}else if(figura instanceof Círculo) {
				System.out.println("\n>>> Círculo");
				((Círculo) figura).calcularArea(5);
				((Círculo) figura).calcularPerimetro(5);
			}
		}
	}

}
