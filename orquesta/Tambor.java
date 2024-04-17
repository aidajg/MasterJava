package ejercicios.orquesta;

public class Tambor extends Instrumento{
	//atributos
	protected String tamaño;
	
	//constructor
	public Tambor(String nombre, String tipo, String tamaño) {
		super(nombre, tipo);
		this.tamaño = tamaño;
	}
	
	//métodos
	@Override
	public void tocar() {
		System.out.println("🥁 Aporreando tambor.");
	}
}
