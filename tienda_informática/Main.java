package ejercicios.tienda_informática;

public class Main {

	public static void main(String[] args) {
		Ordenador o = new Ordenador(180, "King Mod Liquid", 6800, 13, "i9 14900K 24-Core", "48GB", "SSD 2TB");
		Móvil m = new Móvil(204, "Chip A16 Bionic", 800, 8, "Vodafone");
	
		System.out.println(o.toString() + "\n" + m.toString());
	}
}
