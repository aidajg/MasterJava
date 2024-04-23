package ejercicios.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

	public static void main(String[] args) {

		/**
		 * Crear la lista de Usuarios de la Biblioteca Socios + Ocasionales
		 */
		Socio ana = new Socio("000111222X", "Ana López");
		Ocasional marta = new Ocasional("000222333X", "Marta López");
		Ocasional luis = new Ocasional("000888999X", "Luis Torres");
		Socio cecilia = new Socio("000444555V", "Cecilia Moreno");
		Socio elena = new Socio("222000111C", "Elena Vázquez");
		Socio sonia = new Socio("222333000S", "Sonia Vega");
		Ocasional felipe = new Ocasional("666000333F", "Felipe González");

		// Agregar a la lista de Usuarios
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(ana);
		usuarios.add(marta);
		usuarios.add(luis);
		usuarios.add(cecilia);
		usuarios.add(elena);
		usuarios.add(sonia);
		usuarios.add(felipe);

		/**
		 * Crear la lista de documentos que forman la biblioteca Libros + Revistas
		 */
		Libros narnia = new Libros("P101", "Las crónicas de Narnia", 2000, false);
		Libros harryPotter = new Libros("P204", "Harry Potter y la piedra filosofal", 1999, false);
		Libros cocina = new Libros("P209", "Cocina con Paco", 2003, false);
		Libros terror = new Libros("P090", "La casa encantada", 1990, false);
		Revistas hola = new Revistas("B008", "Hola!", false);
		Revistas paraiso = new Revistas("B800", "Paraiso, nueva edición", false);
		Revistas corazon = new Revistas("B030", "Corazón y Actualidad", false);
		Revistas woman = new Revistas("B040", "Woman Today, Secretos de belleza", false);

		// Agregar a la lista de Documentos
		List<Documento> documentos = new ArrayList<>();
		documentos.add(narnia);
		documentos.add(harryPotter);
		documentos.add(cocina);
		documentos.add(terror);
		documentos.add(hola);
		documentos.add(paraiso);
		documentos.add(corazon);
		documentos.add(woman);

		/**
		 * Casos de uso para Bibliotecario
		 * 
		 * @param num -> acción escogida
		 * @while -> bucle infinito hasta que el usuario envíe 0 (exit)
		 */
		int num = 1;
		Documento documento = null;
		while(num != 0) {
		System.out.println("\nHola Bibliotecari@, qué quieres hacer?");
		System.out.println("1 -- Seleccionar Documento\n2 -- Prestar Documento (Actual)" +
						"\n3 -- Devolver Documento (Actual)\n4 -- Buscar Documentos\n5 -- Informe de préstamos\n0 -- Salir");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		switch (num) {
		case 1:
			/**
			 * Seleccionar Documento.
			 * 
			 * Se busca en el array de documentos (libros y revistas)
			 * alguno que coincida con el código proporcionado por teclado, si lo encuentra lo devuelve.
			 */
			System.out.print("Código del Documento: ");
			String codigo = sc.next();
			boolean docEncontrado = false;
			for (Documento doc : documentos) {
				if (doc.getCodigo().equals(codigo)) {
					docEncontrado = true;
					documento = doc;
					System.out.println("Documento encontrado: " + documento.getTitulo() + " [DOCUMENTO ACTUAL]");
					break;
				}
			}
			if (!docEncontrado) {
				System.out.println("No se han encontrado documentos con código: " + codigo);
			}
			break;

		case 2:
			/**
			 * Prestar Documento (Actual)
			 * 
			 * Comprobar en array Usuarios si:
			 *- Existe un usuario con el DNI indicado
			 *- No ha alcanzado el límite de préstamos
			 *- El documento actual no está prestado ya
			 */
			try {
				
			if (documento != null && !documento.isPrestado()) {
				System.out.print("DNI del usuario: ");
				String dni = sc.next();
				boolean encontrado = false;
				for (Usuario user : usuarios) {
					if (user.getDni().equals(dni) && user.enPosesion.size() < user.getDocumentosMax()){
						encontrado = true;
						System.out.println("Préstamo realizado a " + user.toString());
						user.enPosesion.add(documento);
						break;
					}
					if(!encontrado && user.enPosesion.size() > user.getDocumentosMax()) {
					System.out.println("Préstamo no se ha podido realizar. No se ha encontrado Cliente o Préstamo máximo alcanzado." + user.enPosesion.size());
				}
				}
			}
			
			}catch (Exception e) {
				System.out.println("No hay ningún documento seleccionado.");
			}
			break;

		case 3:
			/**
			 * Devolver Documento (Actual)
			 * 
			 * Comprobar que el documento no está prestado, ni sea nulo.
			 * Si no está prestado, asignar el documento a un Usuario.
			 * Si ya está prestado, dejarlo así y notificar.
			 */
			boolean esPrestado = documento.isPrestado();
			if (documento.isPrestado() && documento != null) {
				for(Usuario user : usuarios) {
					if(user.enPosesion.equals(documento)) {
						user.enPosesion.remove(documento);
					}
				}
				esPrestado = false;
				System.out.println("Se va a devolver el siguiente documento: " + documento.getTitulo());
				break;
			}else {
				esPrestado = true;
				System.out.println("No se ha podido devolver el documento Actual: (" + documento.getCodigo() + "), Título: " + documento.getTitulo());
			}
			break;
			

		case 4:
			/**
			 * Buscar Documento por Título
			 * 
			 * Recorre arraylist de documentos hasta que encuentra uno con el mismo
			 * título que el proporcionado, y lo devuelve.
			 */
			System.out.print("Buscar por Título: ");
			String titulo = sc.next();
			boolean tituloEncontrado = false;
			for(Documento doc : documentos) {
				if(doc.getTitulo().equals(titulo)) {
					documento = doc;
					tituloEncontrado = true;
					System.out.println("Documentos encontrados: " + documento.getTitulo());
					break;
				}
			}
			if (!tituloEncontrado) {
				System.out.println("No se han encontrado documentos con Título: " + titulo);
			}
			
			break;

		case 5:
			/**
			 * Informe de Préstamos
			 * 
			 * Mostrar todos los préstamos existentes con:
			 * Título, año publicación (si es Libro), código, plazo préstamo y usuario prestatario.
			 */
			break;
			
		}//switch
	
		}//while
		
	}//main

} // clase
