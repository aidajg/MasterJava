package ejercicios.biblioteca;

import java.util.ArrayList;

public class Usuario {
	//atributos
	protected final String dni; //-> seteado en cada clase hija
	protected String nombre;
	protected static int documentosMax; //-> seteado en cada clase hija
	protected static int prestamoLibros;//-> seteado en cada clase hija
	protected static int prestamoRevistas;//-> cálculo mediante método
	protected ArrayList<Documento> enPosesion;
	
	//constructor (dni) -> único
	public Usuario(String dni) {
		this.dni = dni;
	}
	
	//constructor general
	public Usuario(String dni, String nombre, int documentosMax, int prestamoLibros, int prestamoRevistas, ArrayList<Documento> enPosesion) {
		this.dni = dni;
		this.nombre = nombre;
		this.documentosMax = documentosMax;
		this.prestamoLibros = prestamoLibros;
		this.prestamoRevistas = prestamoRevistas;
		this.enPosesion = enPosesion;
	}

	
	//get&set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni; //-> recuperable no seteable
	}

	public int getDocumentosMax() {
		return documentosMax; //-> recuperable no seteable
	}

	public int getPrestamoLibros() {
		return prestamoLibros;
	}

	public void setPrestamoLibros(int prestamoLibros) {
		this.prestamoLibros = prestamoLibros;
	}

	public int getPrestamoRevistas() {
		return prestamoRevistas;
	}

	public void setPrestamoRevistas(int prestamoRevistas) {
		this.prestamoRevistas = prestamoRevistas;
	}
	


	/**
	 * Calcula el préstamo máximo (días) de una revista
	 * en función del tipo de usuario
	 * @return -> préstamo máximo
	 */
	public int calcularPrestamoRevista() {
		int prestamo_max = getPrestamoLibros();
		int prestamo_maxRevista = prestamo_max / 3;
		return prestamo_maxRevista;
	}

	/**
	 * Método que muestra al usuario al que se le ha prestado el documento
	 * @return -> clase del usuario (socio / ocasional)
	 */
	@Override
	public String toString() {
		String clase = getClass().getName();
		if(clase.matches("Socio")) {
			return "\t" + dni + "(Socio)";
		}else if(clase.matches("Ocasional")) {
			return "\t" + dni + "(Usuario Ocasional)";
		}
		return clase;
	}
	
	/**
	 * Método para mostrar todos los datos de los usuarios
	 * @return
	 */
	public String mostrarCredenciales() {
		return "Usuario (DNI: " + dni + ")\nNombre: " + nombre + "\nMáximo: " + documentosMax + "documentos.\nPréstamo máximo Libros: " + prestamoLibros + "días.\nPréstamo máximo Revistas: " + prestamoRevistas + " días.";
	}
	
	
	
}
