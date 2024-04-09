package ejercicios.tienda_informática;

public class Producto {
	//atributos
	private int codigo;
	private String modelo;
	private double precio;
	private int cantidad;
	
	//constructor
	public Producto(int codigo, String modelo, double precio, int cantidad) {
		super();
		this.codigo = codigo;
		this.modelo = modelo;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	//get&set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	//toString
	@Override
	public String toString() {
		return "Producto (Código: " + codigo + "), modelo: " + modelo + ", precio: " + precio + ". Cantidad disponible en tienda: " + cantidad;
	}
	
	
	
	

}
