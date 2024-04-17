package ejercicios.orquesta;

public class Instrumento {
	//atributos
	protected String nombre;
	protected String tipo;
	
	//constructor vacío
	public Instrumento() {
		
	}
	
	//constructor con parámetros
	public Instrumento(String nombre, String tipo) {
		this();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	//get&set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	//métodos
	public void tocar() {
		System.out.println("Tocando el instrumento: " + getNombre());
	}
	public void afinar() {
		System.out.println("Afinando el instrumento: " + getNombre());
	}
	
}
