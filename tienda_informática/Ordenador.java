package ejercicios.tienda_informática;

public class Ordenador extends Producto{
	
	//atributos singulares de la clase
	private String procesador;
	private String memoria;
	private String disco;
	
	//constructor heredado
	public Ordenador(int codigo, String modelo, double precio, int cantidad, String procesador, String memoria, String disco) {
		super(codigo, modelo, precio, cantidad);
		this.procesador = procesador;
		this.memoria = memoria;
		this.disco = disco;
	}

	
	//get&set
	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getDisco() {
		return disco;
	}

	public void setDisco(String disco) {
		this.disco = disco;
	}
	
	

}
