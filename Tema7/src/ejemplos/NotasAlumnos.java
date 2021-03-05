package ejemplos;

import java.util.HashMap;
import java.util.Iterator;

public class NotasAlumnos {
	HashMap <String, float[]> mapa;
	
	public NotasAlumnos() {
		mapa=new HashMap <String, float[]>();
	}
	void aniadirAlumno(String nom) {
		float[]notas=new float[2];
		for (int i = 0; i < notas.length; i++) {
			notas[i]=(float)(Math.random()*10);
		}
		mapa.put(nom, notas);
	}
	float[] mediasAlumnos() {
		float[] media=new float[mapa.size()];
		String nom;
		float suma=0;
		int cont=0, aux=0;
		Iterator <String> it=mapa.keySet().iterator();
		while(it.hasNext()) {
			nom=it.next();
			float[] arr=mapa.get(nom);
			suma=0;
			cont=0;
			for (int i = 0; i < arr.length; i++) {
				suma=suma+arr[i];
				cont++;
			}
			suma=suma/cont;
			media[aux]=suma;
			aux++;
		}
		return media;
	}
	void verMapa() {
		float[] aux=new float[2];
		Iterator <String> it=mapa.keySet().iterator();
		while(it.hasNext()) {
			String caja;
			caja=it.next();
			System.out.print(caja+"\t  ");
			aux=mapa.get(caja);
			for (int i = 0; i < aux.length; i++) {
				System.out.print(aux[i]+"\t");
			}
			System.out.println();
		}
	}
	static void verArray(float[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		NotasAlumnos na=new NotasAlumnos();
		na.aniadirAlumno("Alayn");
		na.aniadirAlumno("Adrian");
		na.aniadirAlumno("Roberto");
		na.verMapa();
		verArray(na.mediasAlumnos());
	}
}
