package ejercicios.figuras;

public class Cuadrado extends Figura {
	// atributos
	protected int num;

	// constructor
	public Cuadrado(String nombre) {
		super("Cuadrado");
	}

	public void calcularArea(int num) {
		int area = num * num;
		System.out.println("Área del cuadrado siendo lado " + num + "cm = " + area);
	}

	public void calcularPerimetro(int num) {
		int perimetro = (int) Math.pow(num, 4);
		System.out.println("Perímetro del cuadrado = " + perimetro);
	}

}
