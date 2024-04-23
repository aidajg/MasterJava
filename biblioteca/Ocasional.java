package ejercicios.biblioteca;

import java.util.ArrayList;

public class Ocasional extends Usuario {
	public static ArrayList<Documento> enPosesion;

	//constructor del padre
	public Ocasional(String dni, String nombre) {
		super(dni, nombre, documentosMax, prestamoLibros, prestamoRevistas, enPosesion);
		int documentosMax = 2;
		int prestamoLibros = 15; //-> días
		int prestamoRevistas = calcularPrestamoRevista();
		this.enPosesion = enPosesion;
	}
	
}
