package ejercicios.cuenta;

public class Cuenta {
	protected String titular;
	protected Double cantidad;
	
	//constructor
	public Cuenta(String titular) {
		this.titular = titular;
	}
	
	//constructor empty
	public Cuenta() {
		
	}

	//get&set
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
		System.out.println("\nEl titular de la cuenta es " + titular);
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
		System.out.println("Saldo actual en la cuenta: " + cantidad);
		
	}
	
	//métodos
	public void ingresar(Double c, Cuenta a) {
		Double ingreso =  c + a.getCantidad();
		if(c > 0) { 
			System.out.println("\n***Se han ingresado " + c + " euros.");
			a.setCantidad(ingreso);
		}
	}
	
	public void retirar(Double c, Cuenta a) {
		Double retirar =  a.getCantidad() - c;
		if(retirar > 0){
			System.out.println("\n---Se han retirado " + c + " euros.");
			a.setCantidad(retirar);
		}else {
			System.out.println("\n---Se han retirado " + c + " euros. Saldo insuficiente.");
			a.setCantidad(0.0);
		}
	}
	
}
