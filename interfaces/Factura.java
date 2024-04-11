package ejercicios.interfaces;

public class Factura implements Imprimible{
	//atributos
	protected int nFactura;
	protected int codigoCliente;
	
	//constructor
	public Factura(int nFactura, int codigoCliente) {
		this.nFactura = nFactura;
		this.codigoCliente = codigoCliente;
	}
	
	//get&set
	public int getnFactura() {
		return nFactura;
	}
	
	public void setnFactura(int nFactura) {
		this.nFactura = nFactura;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	/**
	 * Override para el método Imprimible
	 */
	
	public void informeCorto() {
		System.out.println("\nNúmero de factura: " + getnFactura());
	}
	
	public void informeLargo() {
		System.out.println("Número de factura: " + getnFactura() + " y código cliente " + getCodigoCliente());
	}
}
