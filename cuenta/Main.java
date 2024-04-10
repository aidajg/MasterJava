package ejercicios.cuenta;

public class Main {
	public static void main(String[] args) {
		
		Cuenta aida = new Cuenta();
		aida.setTitular("Aida");
		aida.setCantidad(300.00);
		
		aida.ingresar(50.90, aida);
		aida.retirar(320.0, aida);
		
		aida.retirar(32.0, aida);
	}
}
