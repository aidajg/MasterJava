package ejercicios.interfaces;

public abstract class GestionImpresion implements Imprimible{
	
	//método
	public static void crear() {
		Página p = new Página(2, 20);
		Factura f = new Factura(999, 111);
		
		p.informeCorto();
		p.informeLargo();
		
		f.informeCorto();
		f.informeLargo();
	}
	
//main
public static void main(String[] args) {
	
	crear();
}

}
