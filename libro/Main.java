package ejercicios.libro;

public class Main {

	public static void main(String[] args) {
		//Libros
		Libro narnia = new Libro("978-987-25620-2-1", "Las Crónicas de Narnia", "C.S. Lewis", 816 );
		Libro diario = new Libro("802-677-34050-0-2", "Diario de Ana Frank", "Annelies Marie Frank", 384);
		
		System.out.println(narnia.toString());
		System.out.println(diario.toString());
		
		//cuál tiene más páginas
		if(narnia.getPaginas() > diario.getPaginas()) {
			System.out.println("\n>>Narnia tiene más páginas que El Diario de Ana Frank.");
		}else {
			System.out.println("\n>>El Diario de Ana Frank tiene más páginas que Narnia.");
		}
	
	}
}
