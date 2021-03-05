package ejemplotuberias;

import java.io.Serializable;

public class Alumno implements Serializable{
	private String nombre;
	private int edad;
	private float[] notas;
	
	public Alumno(String nom, int ed, float[] not) {
		nombre=nom;
		edad=ed;
		notas=not;
	}
	public void mostrarAlumno() {
		System.out.println("Nombre:"+nombre+" Edad:"+edad+" Notas:");
		for (int i = 0; i < notas.length; i++) {
			System.out.print(notas[i]+"  |  ");
		}
		System.out.println();
	}
	
	public int getEdad() {
		return edad;
	}
	public float[] getNotas() {
		return notas;
	}
	public static void main(String[] args) {
		Alumno al1=new Alumno("Pepe", 15, new float[] {4,4,5,8,9});
		al1.mostrarAlumno();
	}
}
