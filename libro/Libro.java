package ejercicios.libro;

public class Libro {
	//atributos
	protected String isbn;
	protected String titulo;
	protected String autor;
	protected int paginas;
	
	//constructor
	public Libro(String isbn, String titulo, String autor, int paginas) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
	}
	
	
	//get&set
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "El libro '" + titulo + "' con ISBN " + isbn + ", creado por el autor: '" + autor + "', tiene " + paginas + " paginas.";
	}
	
}
