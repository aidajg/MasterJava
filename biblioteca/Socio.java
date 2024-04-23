package ejercicios.biblioteca;

import java.util.ArrayList;

public class Socio extends Usuario {
	public static ArrayList<Documento> enPosesion;

	//constructor del padre
	public Socio(String dni, String nombre) {
		super(dni, nombre, documentosMax, prestamoLibros, prestamoRevistas, enPosesion);
		int documentosMax = 20;
		int prestamoLibros = 30; //-> días
		int prestamoRevistas = calcularPrestamoRevista();
		this.enPosesion = enPosesion;
	}
	
}
