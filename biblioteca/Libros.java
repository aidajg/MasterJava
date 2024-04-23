package ejercicios.biblioteca;

public class Libros extends Documento{
	//atributo propio de la clase
	protected int añoPublicacion;
	
	//constructor
	public Libros(String codigo, String titulo, int añoPublicacion, boolean prestado) {
		super(codigo, titulo, prestado);
		this.añoPublicacion = añoPublicacion;
	}

	//get&set
	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

}
