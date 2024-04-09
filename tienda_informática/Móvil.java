package ejercicios.tienda_informática;

public class Móvil extends Producto{
	//atributos singulares
	private String operador;
	
	//constructor heredado
	public Móvil(int codigo, String modelo, double precio, int cantidad, String operador) {
		super(codigo, modelo, precio, cantidad);
		this.operador = operador;
	}

	//get&set
	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	
}
