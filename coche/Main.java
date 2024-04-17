package ejercicios.coche;

import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
	//Instancias de vehículos y 'no vehículos' (caballos)
	Vehiculo mercedes = new Coche("3546NX", "Mercedes", "G500", "Blanco", 8, 210, 130000);
	Vehiculo audi = new Coche("6789ZX", "Audi", "R8", "Rojo", 6, 330, 181000);
	Vehiculo bergamont = new Bici("Bergamont", "E-Cargoville", "Verde", 1200);
	Vehiculo yegua = new Caballo("Pura Sangre", "Marrón", 400, 70, 5000);
	Vehiculo frison = new Caballo("Frisón", "Negro", 900, 35 , 34780);
	Vehiculo camion = new Camion("3059MT", "Renault", "Comb 2007", "Gris", 14000, 358, 41000);
	
	//Lista de vehículos (y 'no vehículos')
	ArrayList<Vehiculo> v = new ArrayList<Vehiculo>();
	v.add(mercedes);
	v.add(audi);
	v.add(bergamont);
	v.add(yegua);
	v.add(frison);
	v.add(camion);
	
	
	//Lista de Destinos disponibles para viajar
	ArrayList<Destino> d = new ArrayList<Destino>();
	d.add(Destino.CASA);
	d.add(Destino.TRABAJO);
	d.add(Destino.CENTRO);
	d.add(Destino.AFUERAS);
	d.add(Destino.CENTROCOMERCIAL);
	
	
	/**
	 * Ejecución de los métodos según la instancia
	 */
	for(Vehiculo vehiculo : v) {
		//-> caso Coches
		if(vehiculo instanceof Coche) {
			System.out.println("Categoría: Coches");
			Coche coche = (Coche) vehiculo;
			System.out.println("Marca --->" + coche.getMarca() + " " + coche.getModelo() + ".[[ Matrícula (" + coche.getMatricula() + ") ]]");
			coche.getNumRuedas();
			//-> si la matrícula corresponde con 'Mercedes'
			if(coche.getMatricula().equals(mercedes.getMatricula())) {
				vehiculo.llenarDeposito(10);
				vehiculo.elegirDestino(Destino.TRABAJO);
				vehiculo.acelerar(50);
			//-> si la matrícula corresponde con 'Audi'
			}else if(coche.getMatricula().equals(audi.getMatricula())) {
				vehiculo.cambiarColor("Dorado");
				vehiculo.llenarDeposito(5);
				vehiculo.elegirDestino(Destino.AFUERAS);
			}
		//-> caso Bicis
		}else if(vehiculo instanceof Bici) {
			System.out.println("Categoría: Bicicletas");
			Bici bici = (Bici) vehiculo;
			bici.getNumRuedas();
			bici.cambiarColor("Rojo");
			bici.elegirDestino(Destino.CENTROCOMERCIAL);
			bici.conducir(3);
			bici.acelerar(5);
		//-> caso Caballos
		}else if(vehiculo instanceof Caballo) {
			System.out.println("Categoría: Caballos");
			Caballo cb = (Caballo) vehiculo;
			System.out.println("Raza ---> " + cb.getRaza() + " de color " + cb.getColor());
			System.out.println(cb.getRaza() + " alcanza hasta los " + cb.getKilometraje() + " km de máximo y cuesta " + cb.getPrecio() + " euros.");
			//-> Si la raza es 'Yegua'
			if(cb.getRaza().equals(yegua.getRaza())) {
				cb.llenarDeposito(30);
				cb.elegirDestino(Destino.AFUERAS);
				cb.conducir(15);
				cb.frenar();
			//-> Si la raza es 'Frisón'
			}else if(cb.getRaza().equals(frison.getRaza())) {
				cb.llenarDeposito(80);
				cb.acelerar(30);
			}
		//-> caso Camión
		}else if(vehiculo instanceof Camion) {
			System.out.println("Categoría: Camiones");
			Camion cm = (Camion) vehiculo;
			System.out.println("Marca --->" + cm.getMarca() + " " + cm.getModelo() + ".[[ Matrícula (" + cm.getMatricula() + ") ]]");
			cm.getNumRuedas();
			cm.elegirDestino(Destino.AFUERAS);
			cm.calcularVelocidades();
		}
		System.out.println();
	}
	
}
}
