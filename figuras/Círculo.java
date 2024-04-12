package ejercicios.figuras;

public class Círculo extends Figura {
	//atributos
	protected int num;
	
	//constructor
	public Círculo() {
	}
	
	public void calcularArea(int num) {
		double area = 3.14*(Math.pow(num, 2));
		System.out.println("Área del círculo, siendo radio " + num + "cm = " + area);
	}

	public void calcularPerimetro(int num) {
		double perimetro = 2*(3.14*num);
		System.out.println("Perímetro del círculo = " + perimetro);
	}

}
