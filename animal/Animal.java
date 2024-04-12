package ejercicios.animal;

public class Animal {
	//Atributos
	protected int numpatas;
	
	//Constructor
	public Animal(int numpatas) {
		this.numpatas = numpatas;
	}
	
	//get&set
	public int getNumpatas() {
		return numpatas;
	}

	public void setNumpatas(int numpatas) {
		this.numpatas = numpatas;
	}
	
	//Métodos
	public void comer() {
	}
	
	public void andar() {
		System.out.println("Este animal anda sobre " + numpatas + " patas.");
	}

	public void jugar() {
	}

}
