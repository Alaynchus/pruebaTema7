package tanda1ejercicio3;

import java.io.Serializable;

public class Comercial implements Serializable{
	String nombre;
	int salario;
	TelefonoMovil telefono;
	
	public Comercial(String nom, int sald, TelefonoMovil tel) {
		nombre=nom;
		salario=sald;
		telefono=tel;
	}
	public Comercial(String nom, int sald) {
		nombre=nom;
		salario=sald;
	}
	public void ver() {
		System.out.println("El comercial "+nombre+" tiene de salario "+salario+" y el telefono "+telefono);
	}
	public void trabajar() {
		salario=salario+10;
		telefono.llamar(15);
	}
	public void trabajar(int g, int m) {
		salario=salario+g;
		telefono.llamar(m);
	}
	public String getNombre() {
		return nombre;
	}
	public TelefonoMovil getTelefono() {
		return telefono;
	}
	
}
