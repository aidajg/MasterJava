package ejercicios.Orquesta;

public class Flauta extends Instrumento{
	//atributos
	protected String modelo;

	//constructor (hereda del padre)
	public Flauta(String nombre, String tipo, String modelo) {
		super(nombre, tipo);
		this.modelo = modelo;
	}

	/**
	 * Se sobreescribe el método del padre, ajustándolo a Flauta
	 */
	@Override
	public void tocar() {
		super.tocar();
		System.out.println("💨 Soplando.");
	}
	
}
