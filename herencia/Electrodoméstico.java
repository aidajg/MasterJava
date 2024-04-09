package ejercicios.herencia;

public class Electrodoméstico {
	private String modelo;
	private Double precio;
	private Integer voltaje;
	
	
	//Constructor
	public Electrodoméstico(String modelo, Double precio, Integer voltaje) {
		super();
		this.modelo = modelo;
		this.precio = precio;
		this.voltaje = voltaje;
	}
	
	//Get&Set
	public String getModelo() {
		return modelo;
	}

	public void setNombre(String modelo) {
		this.modelo = modelo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getVoltaje() {
		return voltaje;
	}

	public void setVoltaje(Integer voltaje) {
		this.voltaje = voltaje;
	}

	//Métodos
	protected String apagar() {
		return "⚙️ > Se ha apagado " + getModelo();
	}
	
	protected String encender() {
		return "⚙️ > Se ha encendido " + getModelo();
	}
	
	protected String play() {
		encender();
		return " 🎵 > Está sonando música en el " + getModelo();
	}
	
	protected String rewind() {
		return " ⏪ > Rewind: Se repetirá la canción.";
	}
}
