package ejercicios.coche;

public interface conducible {
	/**
	 * Mutables en función de la clase
	 * @Caballo -> caminar() - galopar() - parar() - retroceder() - alimentar()
	 * @Barco -> navegar() - acelerar() - girar() - frenar()
	 * @Avión -> planear() - acelerar() - girar() - aterrizar()
	 */
	public void conducir(int km);
	public void acelerar(int km);
	public void retroceder(int m);
	public void frenar();
	public void llenarDeposito(int L);
}
