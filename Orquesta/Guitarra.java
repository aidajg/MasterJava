package ejercicios.Orquesta;

public class Guitarra extends Instrumento{
	//atributos
	protected int num_cuerdas;

	//constructor
	public Guitarra(String nombre, String tipo, int num_cuerdas) {
		super(nombre, tipo);
		this.num_cuerdas = num_cuerdas;
	}
}
