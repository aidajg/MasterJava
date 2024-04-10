package ejercicios.libro;

public class Libro {
	//atributos
	public static int contador;
	
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
		
		contador++;
	}
	
	public Libro() {
		contador++;
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
	
	
	//método (averiguar cuál tiene más páginas)
	public void masPaginas(Libro a, Libro b) {
		if(a.getPaginas() > b.getPaginas()) {
			System.out.println("\n>>" + a.getTitulo() + " tiene más páginas que " + b.getTitulo());
		}else if (a.getPaginas() == b.getPaginas()){
			System.out.println("\n>>" + b.getTitulo() + " y " + a.getTitulo() + " tienen las mismas páginas.");
		}else {
			System.out.println("\n>>" + b.getTitulo() + " tiene más páginas que " + a.getTitulo());
		}
	}
}
