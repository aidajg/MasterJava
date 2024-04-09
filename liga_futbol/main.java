package ejercicios.liga_futbol;


public class main {

public static void main(String[]args) {
	
	//array de jugadores
	Jugador [] jugadores_bulls = new Jugador[4];
	jugadores_bulls[0] = new Jugador("Marcos", 3, 1);
	jugadores_bulls[1] = new Jugador("Sandra", 5, 2);
	jugadores_bulls[2] = new Jugador("Oliver", 2, 6);
	jugadores_bulls[3] = new Jugador("Tony", 5, 4);
	
	Jugador [] jugadores_tigers = new Jugador[4];
	jugadores_tigers[0] = new Jugador("Santi", 5, 10);
	jugadores_tigers[1] = new Jugador("Natalia", 3, 4);
	jugadores_tigers[2] = new Jugador("Eva", 5, 2);
	jugadores_tigers[3] = new Jugador("Sonia", 3, 3);
	
	//equipos
	Equipo bulls = new Equipo("Bulls", 5, "Champions", jugadores_bulls);
	Equipo tigers = new Equipo("Tigers", 8, "Champions", jugadores_tigers);
	
	
	System.out.println("Jugadores del equipo 'Bulls'= " + golesMarcados(jugadores_bulls) + "\n" + partidosJugados(jugadores_bulls));
	
	System.out.println("\nJugadores del equipo 'Tigers'= " + golesMarcados(jugadores_tigers) + "\n" + partidosJugados(jugadores_tigers));
	
	partidosGanados(bulls, tigers);
	}


//Por goles marcados
public static String golesMarcados(Jugador[] array) {
	String lista = "";
	for (int i = 0; i < array.length; i++) {
			lista += array[i].getNombre() + ", ";
		}
	return lista;
}

//Partidos y resultados
public static String partidosJugados(Jugador[] array) {
	Integer partidos = 0;
	Integer goles = 0;
	String resultado = "";
	for (int i = 0; i < array.length; i++) {
		partidos += array[i].getPartidos();
		goles += array[i].getGoles();
	}
	resultado = "Partidos jugados= " + partidos + "\nResultados= " + goles + " goles en total.";
	return resultado;
}

//Por partidos ganados
public static String partidosGanados(Equipo a, Equipo b){
	String orden = "";
	if(a.getPartidos_ganados() > b.getPartidos_ganados()) {
		orden = "\nOrden de los equipos (según partidos ganados): \n 1º:" + a.getNombre() + "\n 2º:" + b.getNombre();
	}else {
		orden = "\nOrden de los equipos (según partidos ganados): \n 1º:" + b.getNombre() + "\n 2º:" + a.getNombre();
	}
	System.out.println(orden);
	return orden;
}

}//main
