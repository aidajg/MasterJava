package ejercicios.liga_futbol;

public class Jugador {
	private String nombre;
	private Integer partidos;
	private Integer goles;
	
	//Constructor
	public Jugador(String nombre, Integer partidos, Integer goles) {
		super();
		this.nombre = nombre;
		this.partidos = partidos;
		this.goles = goles;
	}

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPartidos() {
		return partidos;
	}

	public void setPartidos(Integer partidos) {
		this.partidos = partidos;
	}

	public Integer getGoles() {
		return goles;
	}

	public void setGoles(Integer goles) {
		this.goles = goles;
	}


}
