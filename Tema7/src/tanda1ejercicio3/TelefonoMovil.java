package tanda1ejercicio3;

import java.io.Serializable;

public class TelefonoMovil implements Serializable {
	private int numero, saldo;
	
	public TelefonoMovil(int num, int sal) {
		numero=num;
		saldo=sal;
	}
	public void ver() {
		System.out.println("El numero de este telefono es "+numero+" y tiene "+saldo+" de saldo");
	}
	public void cargar(int s) {
		saldo=saldo+s;
	}
	
	public void llamar(int minutos) {
		//se puede quedar en negativo?
		saldo=saldo-minutos*2;
	}
	@Override
	public String toString() {
		return  numero + " con " + saldo +" de saldo";
	}
	
	
}
