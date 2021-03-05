package tanda1ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio1 {
	
	public static void byteabyte(String nomimagen) throws IOException {
		FileInputStream fis= new FileInputStream(nomimagen);
		String nomout;
		nomout=nomimagen.substring(0, nomimagen.indexOf('.'));
		nomout=nomout+"_CPY.";
		nomout=nomout+nomimagen.substring(nomimagen.indexOf('.')+1, nomimagen.length());
		FileOutputStream fos= new FileOutputStream(nomout);
		while(fis.available()>0) {
			fos.write(fis.read());
		}
		fis.close();
		fos.close();
	}
	public static void aBloques(String nomimagen) throws IOException {
		final int N=512;
		FileInputStream fis= new FileInputStream(nomimagen);
		String nomout;
		nomout=nomimagen.substring(0, nomimagen.indexOf('.'));
		nomout=nomout+"_CPY.";
		nomout=nomout+nomimagen.substring(nomimagen.indexOf('.')+1, nomimagen.length());
		FileOutputStream fos= new FileOutputStream(nomout);
		byte[] bloque=new byte[N];
		while(fis.available()>N-1) {
			fis.read(bloque);
			fos.write(bloque);
		}
		int restantes=fis.read(bloque);
		fos.write(bloque, 0, restantes);
		fis.close();
		fos.close();
	}
	public static void unalectura(String nomimagen) throws IOException {
		File f=new File(nomimagen);
		FileInputStream fis= new FileInputStream(f);
		String nomout;
		nomout=nomimagen.substring(0, nomimagen.indexOf('.'));
		nomout=nomout+"_CPY.";
		nomout=nomout+nomimagen.substring(nomimagen.indexOf('.')+1, nomimagen.length());
		FileOutputStream fos= new FileOutputStream(nomout);
		byte[] bloque=new byte[(int) f.length()];
		int restantes=fis.read(bloque);
		fos.write(bloque, 0, restantes);
		fis.close();
		fos.close();
		
	}
	public static void main(String[] args) throws IOException {
	unalectura("messi.jpg");
		
	}
}
