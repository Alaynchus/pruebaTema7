package ejercicio4tanda3;

import java.io.Console;
import java.util.HashMap;
import java.util.Iterator;

public class Agenda {
	HashMap <String, int[]> entradas;
	int maxent;
	
	public Agenda(int maxent) {
		this.maxent=maxent;
		entradas=new HashMap<>();
	}
	public void añadeEntrada(String nom, int[] tlf) {
		Iterator <String> it=entradas.keySet().iterator();
		int[] telefonos;
		if(entradas.size()>=maxent) {
			System.out.println("Las entradradas ya estan llenas segun el numero de entradas maximas");
			return;
		}
		while(it.hasNext()) {
			String clave=it.next();
			if(clave.equals(nom)) {
				System.out.print("Su agenda ya dispone de los siguientes telefonos para "+clave+": ");
				telefonos=entradas.get(clave);
				for (int i = 0; i < entradas.get(clave).length; i++) {
					System.out.print(telefonos[i]+"\t");
				}
				System.out.println();
				System.out.println("Desea sustituirlos por los nuevos? S/N");
				char res;
				res=Consola.leeChar();
				if(res=='S'){
					System.out.println("Los telefonos se han cambiado correctamente");
					entradas.put(nom, tlf);
					return;
				}
				else {
					System.out.println("No se han cambiado los numeros de telefono");
					return; 
				}
			}
		}	
				entradas.put(nom, tlf);
	}
	public String buscaNombre(String nom) {
		String tlfs="";
		Iterator <String> it=entradas.keySet().iterator();
		while(it.hasNext()) {
			String clave=it.next();
			if(clave.equals(nom)) {
				for (int i = 0; i < entradas.get(clave).length; i++) {
					tlfs=tlfs+entradas.get(clave)[i]+" ";
				}
				return tlfs;
			}
		}
		tlfs=nom+" no se encuentra en la agenda";
		return tlfs;	
	}
	public int cuantosTelefonos(int tlf) {
		int repetidos=0;
		Iterator <String> it=entradas.keySet().iterator();
		String clave;
		while(it.hasNext()) {
			clave=it.next();
			for (int i = 0; i < entradas.get(clave).length; i++) {
				if(entradas.get(clave)[i]==tlf) {
					repetidos++;
				}
			}
		}
		return repetidos;
	}
	public void verentradas() {
		Iterator <String> it=entradas.keySet().iterator();
		String clave;
		int[] telefonos;
		while (it.hasNext()) {
			clave=it.next();
			System.out.print(clave+"\t");
			telefonos=entradas.get(clave);
			for (int i = 0; i < entradas.get(clave).length; i++) {
				System.out.print(telefonos[i]+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Agenda a1=new Agenda(3);
		int[] tlf1={919203451, 923095476};
		int[] tlf2={965742358, 919203451};
		int[] tlf3={546754321, 867507213};
		a1.añadeEntrada("Alayn", tlf1);
		a1.añadeEntrada("Alayn", tlf2);
		a1.verentradas();
		System.out.println(a1.cuantosTelefonos(919203451));
	}
}
