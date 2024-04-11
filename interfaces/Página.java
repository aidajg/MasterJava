package ejercicios.interfaces;

public class Página implements Imprimible{
	//atributos
	protected int nPagina;
	protected int nLineas;
	
	//constructor
	public Página(int nPagina, int nLineas) {
		this.nPagina = nPagina;
		this.nLineas = nLineas;
	}
	
	//get&set
	public int getnPagina() {
		return nPagina;
	}
	
	public void setnPagina(int nPagina) {
		this.nPagina = nPagina;
	}
	public int getnLineas() {
		return nLineas;
	}
	public void setnLineas(int nLineas) {
		this.nLineas = nLineas;
		
	}
	
	/**
	 * Override para el método Imprimible
	 */
	
	public void informeCorto() {
		System.out.println("Número de página: " + getnPagina());
	}
	
	public void informeLargo() {
		System.out.println("Número de página: " + getnPagina() + " y número de líneas " + getnLineas());
	}
}
