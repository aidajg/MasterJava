package ejercicios.animal;

public class Animal {
	//Atributos
	protected int numpatas;
	
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
	

	public void jugar() {
	}
	
	public void andar() {
		System.out.println("Este animal anda sobre " + numpatas + " patas.");
	}

}
