package ejercicios.figuras;

public class Rectángulo extends Figura {
	// atributos
	protected int largo;
	protected int ancho;

	// constructor
	public Rectángulo(String nombre) {
		super("Rectángulo");
	}

	public void calcularArea(int largo, int ancho) {
		int area = largo * ancho;
		System.out.println("Área del réctangulo, siendo largo " + largo + "cm y ancho " + ancho + " cm = " + area);
	}

	public void calcularPerimetro(int largo, int ancho) {
		int perimetro = (largo * 2) + (ancho * 2);
		System.out.println(
				"Perímetro del réctangulo, siendo largo " + largo + " cm y ancho " + ancho + "cm =" + perimetro);
	}
}
