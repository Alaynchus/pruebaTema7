package ejemplotuberias;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Crear un fichero binario al que se le puede aadir cierta cantidad de numeros aleatorios. Lee y visualiza su contenido
public class Numsaleatorios {
	public static void aniadirNums(String nomfich, int cant) throws IOException {
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(nomfich));
		int num;
		for (int i = 0; i < cant; i++) {
			num=(int)(Math.random()*10);
			dos.writeInt(num);;
		}
		dos.close();
	}
	public static void ver(String nomfich) throws IOException {
		DataInputStream dis=new DataInputStream(new FileInputStream(nomfich));
		while(dis.available()>0) {
			System.out.print(dis.readInt()+"  |  ");
		}
	}
	public static void main(String[] args) throws IOException {
		aniadirNums("Numsal", 2);
		ver("Numsal");
	}
}
