package ejercicios.liga_futbol;

import java.util.Arrays;

public class Equipo {
	private String nombre;
	private Integer partidos_ganados;
	private String liga;
	private Jugador jugadores[];
	
	//Constructor
	public Equipo(String nombre, Integer partidos_ganados, String liga, Jugador[] jugadores) {
		super();
		this.nombre = nombre;
		this.partidos_ganados = partidos_ganados;
		this.liga = liga;
		this.jugadores = jugadores;
	}
	

	//Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPartidos_ganados() {
		return partidos_ganados;
	}

	public void setPartidos_ganados(Integer partidos_ganados) {
		this.partidos_ganados = partidos_ganados;
	}

	public String getLiga() {
		return liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}


	
}
