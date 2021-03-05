package tanda1ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Descendente {
	private float[] arr;
	int numutiles;
	public Descendente(int tamax) {
		arr=new float[tamax];
		numutiles=0;
	}
	
	public void aniadenum(int num) {
		if(numutiles==arr.length) {
			System.err.println("El array esta lleno");
			return;
		}
		else {
			if(numutiles==0) {
				arr[0]=num;
				numutiles++;
			}
			else {
				for (int i = 0; i < numutiles; i++) {
					if(num<=arr[i]) {
						for (int j = numutiles-1; j > i-1; j--) {
							arr[j+1]=arr[j];
						}
						arr[i]=num;
						numutiles++;
						return;
					}
				}
				arr[numutiles]=num;
				numutiles++;
			}
		
		}
		
	}
	
	public void borraDuplicados() {
		//Si pones el numero 3 veces repetidas solo se borra una vez 
		for (int i = 1; i < numutiles; i++) {
			if(arr[i-1]==arr[i]) {
				for (int j = i+1; j < numutiles; j++) {
					arr[j-1]=arr[j];
				}
				numutiles--;
			}
		}
		System.out.println();
	}
	public void aniadeNumsArray(String nomfich) throws IOException {
		FileOutputStream fos= new FileOutputStream(nomfich);
		DataOutputStream oss= new DataOutputStream(fos);
		borraDuplicados();
		for (int i = 0; i < numutiles; i++) {
			oss.writeFloat((int) arr[i]);
		}
		oss.close();
	}
	public void aniadeNumsRandom(int liminf, int limsup, int cantnum, String nomfich) throws FileNotFoundException {
		File f=new File(nomfich);
		FileOutputStream fos=new FileOutputStream(f);
		int cont=0;
		float num;
		
		while(cont<cantnum) {
			num=(float)(Math.random()*(limsup+liminf+1)+liminf);
			
		}
	}
	public void ver() {
		for (int i = 0; i < numutiles; i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	public void verArchivo(String nomarch) throws IOException {
		FileInputStream fis= new FileInputStream(nomarch);
		DataInputStream ois=new DataInputStream(fis);
		while(ois.available()>0) {
			System.out.print(ois.readFloat()+"\t");
		}
		ois.close();
	}
	public static void main(String[] args) throws IOException {
		Descendente d1=new Descendente(7);
		d1.aniadenum(5);
		d1.aniadenum(8);
		d1.aniadenum(10);
		d1.aniadenum(6);
		d1.aniadenum(4);
		d1.aniadenum(6);
		d1.aniadenum(8);
		d1.ver();
		d1.aniadeNumsArray("Arraynorep");
		d1.verArchivo("Arraynorep");
	}
}
