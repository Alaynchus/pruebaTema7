package ejemplotuberias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binario1 {
	public static boolean crearFichero(String nomfich) throws IOException {
		File f=new File(nomfich);
		final int N=10;
		FileOutputStream fos;
		if(f.exists()) {
			System.err.println("El archivo ya existe, que quieres hacer");
			System.out.println("A-Dejarlo como está");
			System.out.println("B-Crear nuevo archivo");
			System.out.println("C-Añadir datos");
			char resp=Consola.leeChar();
			while(resp!='A' && resp!='B' && resp!='C') {
				System.out.println("A-Dejarlo como está");
				System.out.println("B-Crear nuevo archivo");
				System.out.println("C-Añadir datos");
				resp=Consola.leeChar();
			}
			if(resp=='A') {
				System.out.println("El archivo quedo como estaba");
				return false;
			}
			else {
				if(resp=='B') {
					fos= new FileOutputStream(f);
				}
				else {
					fos= new FileOutputStream(f,true);
					
				}
				for (int i = 0; i < N; i++) {
					int num=(int)(Math.random()*('Z'-'A')+'A');
					fos.write(num);
				}
				fos.close();
				return true;
			}
		}
		else {
			fos=new FileOutputStream(f);
			for (int i = 0; i < N; i++) {
				int num=(int)(Math.random()*('Z'-'A')+'A');
				fos.write(num);
			}
			fos.close();
			return true;
		}
	}
	public static void verFichero(String nomfich) throws IOException {
		File f=new File(nomfich);
		if (!f.exists()) {
			System.err.println("El archivo no existe");
			return;
		}
		FileInputStream fis=new FileInputStream(f);
		while(fis.available()>0) {
			System.out.print((char)fis.read()+" | ");
		}
		fis.close();
		
	}
	public static void copiarFichero(String nomfichcop, String nomfichpegar) throws IOException {
		File fc=new File(nomfichcop);
		File fp=new File(nomfichpegar);
		FileOutputStream fos=new FileOutputStream(fp);
		FileInputStream fis=new FileInputStream(fc);
		while(fis.available()>0) {
			fos.write(fis.read());
		}
		fis.close();
		fos.close();
	}
	public static void main(String[] args) throws IOException {
		System.out.println(crearFichero("nums.txt"));
		verFichero("nums.txt");
		copiarFichero("nums.txt", "numscopia.txt");
		verFichero("numscopia.txt");
	}
}
