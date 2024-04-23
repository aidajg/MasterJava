package ejercicios.biblioteca;

public class Documento {
	//clase padre -> atributos
	protected String codigo; //-> único
	protected String titulo;
	protected boolean prestado;
	
	//constructor general
	public Documento(String codigo, String titulo, boolean prestado) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.prestado = prestado;
	}

	//get&set
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo; //-> recuperable no seteable
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	
}
