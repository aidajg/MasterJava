package ejercicios.libro;

public class Main {

	public static void main(String[] args) {
		//Libros
		Libro narnia = new Libro("978-987-25620-2-1", "Las Crónicas de Narnia", "C.S. Lewis", 816 );
		Libro diario = new Libro("802-677-34050-0-2", "Diario de Ana Frank", "Annelies Marie Frank", 384);
		
		System.out.println(narnia.toString());
		System.out.println(diario.toString());
		
		//cuál tiene más páginas
		narnia.masPaginas(narnia, diario);
		
		//cuántos libros hay
		System.out.println("\nSe han registrado: " + Libro.contador + " libros.");
	}
}
