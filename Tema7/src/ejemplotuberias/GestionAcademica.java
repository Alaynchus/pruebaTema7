package ejemplotuberias;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GestionAcademica {

	public static void crearFichero(String nomFich) throws IOException {
		int[][] notas= {{8,4,5,6,1},{9,5,4,7,8},{5,4,5,6,3},{1,2,3,1,5},{4,8,9,7,10}};
		FileOutputStream fos=new FileOutputStream(nomFich);
		DataOutputStream dos=new DataOutputStream(fos);
		for (int i = 0; i < notas.length; i++) {
			double suma=0;
			for (int j = 0; j < notas.length; j++) {
				dos.writeInt(notas[i][j]);
				suma+=notas[i][j];
			}
			dos.writeDouble(suma/notas.length);
		}
		fos.close();
		dos.close();
	}
	
	public static void verFichero(String nomFich) throws IOException {
		File f=new File(nomFich);
		DataInputStream dis=new DataInputStream(new FileInputStream(nomFich));
		long tamanioAlumno=5*Integer.BYTES+Double.BYTES;
		long cantAlumno=f.length()/tamanioAlumno;
		for (int i = 0; i < cantAlumno; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(dis.readInt()+"    |    ");
			}
			System.out.println(dis.readDouble());
		}
		dis.close();
	}
	
	public static int[] dameNotasAlumno(String nomFich, int pos) throws IOException {
		File f=new File(nomFich);
		
		//ERROR 1: Archivo no existe
		if(!f.exists()) {
			return null;
		}
		
		//ERROR 2: Posicion no existe
		long tamanioAlumno=5*Integer.BYTES+Double.BYTES;
		long cantAlumno=f.length()/tamanioAlumno;
		if(pos<1||pos>cantAlumno) {
			return null;
		}
		
		DataInputStream dis=new DataInputStream(new FileInputStream(f));
		//Modo 1
		/*for (int i = 1; i < pos; i++) {
			for (int j = 0; j < 5; j++) {
				dis.readInt();
			}
			dis.readDouble();
		}
		
		//Modo 2:
		byte[] anteriores=new byte[(int) (tamanioAlumno*(pos-1))];
		dis.read(anteriores);*/
		//Modo 3
		dis.skip(tamanioAlumno*(pos-1));
		
		int[] notas=new int[5];
		for (int i = 0; i < notas.length; i++) {
			notas[i]=dis.readInt();
		}
		return notas;
	}
	public static void main(String[] args) throws IOException {
		
		crearFichero("notas.bin");
		verFichero("notas.bin");
		int[] notas=dameNotasAlumno("notas.bin", 3);
		if(notas==null) {
			System.err.println("Archivo o posicion erronea");
		}
		else {
			for (int i = 0; i < notas.length; i++) {
				System.out.print(notas[i]+"  |  ");
			}
			System.out.println();
		}
		
	}
}
