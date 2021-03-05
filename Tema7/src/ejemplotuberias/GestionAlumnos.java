package ejemplotuberias;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class GestionAlumnos {
	private String nomfich;
	
	public GestionAlumnos(String nombrefichero) {
		nomfich=nombrefichero;
	}
	
	public void cargarAlumnos(ArrayList <Alumno> alumnos) throws IOException {
		FileOutputStream fos= new FileOutputStream(nomfich);
		ObjectOutputStream oss= new ObjectOutputStream(fos);
		Iterator <Alumno> it=alumnos.iterator();
		while(it.hasNext()) {
			oss.writeObject(it.next());
		}
		oss.writeObject(null);
		oss.close();
	}
	public void cargarArrrayList(ArrayList <Alumno> alumnos) throws IOException {
		FileOutputStream fos= new FileOutputStream(nomfich);
		ObjectOutputStream oss= new ObjectOutputStream(fos);
		oss.writeObject(alumnos);
		oss.close();
	}
	public void verArrayList() throws IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		ArrayList<Alumno> arrList=(ArrayList<Alumno>) ois.readObject();
		Iterator <Alumno> it=arrList.iterator();
		while(it.hasNext()) {
			it.next().mostrarAlumno();
		}
	}
	public void verFicheroAlumnos() throws IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Alumno al=(Alumno) ois.readObject();
		while (al!=null) {
			al.mostrarAlumno();
			al=(Alumno) ois.readObject();
		}
		ois.close();
	}
	
	public void aniadirAlumno(Alumno alumno) throws IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		ArrayList <Alumno> arrayList= new ArrayList <Alumno>();
		Alumno al=(Alumno) ois.readObject();
		while (al!=null) {
			arrayList.add(al);
			al=(Alumno) ois.readObject();
		}
		ois.close();
		arrayList.add(alumno);
		this.cargarAlumnos(arrayList);
	}
	
	public void crearFichMas20(String nomfichmas20) throws IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		FileOutputStream fos= new FileOutputStream(nomfichmas20);
		ObjectOutputStream oss= new ObjectOutputStream(fos);
		Alumno al=(Alumno) ois.readObject();
		while(al!=null) {
			if(al.getEdad()>20) {
				oss.writeObject(al);
			}
			al=(Alumno) ois.readObject();
		}
		oss.writeObject(null);
		ois.close();
		oss.close();
	}
	public void crearFichMedias(String nomFichMedias) throws IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		FileOutputStream fos= new FileOutputStream(nomFichMedias);
		DataOutputStream oss= new DataOutputStream(fos);
		Alumno al=(Alumno) ois.readObject();
		float[] not=al.getNotas();
	}
	public void verfich(String nomFichver) throws ClassNotFoundException, IOException {
		FileInputStream fis= new FileInputStream(nomFichver);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Alumno al=(Alumno) ois.readObject();
		while (al!=null) {
			al.mostrarAlumno();
			al=(Alumno) ois.readObject();
		}
		ois.close();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Alumno al1=new Alumno("Alayn", 18, new float[] {5, 7, 8, 4, 9});
		Alumno al2=new Alumno("Miguel", 20, new float[] {9, 3, 4, 6, 7});
		Alumno al3=new Alumno("Manuel", 19, new float[] {2, 9, 7, 4, 8});
		Alumno al4=new Alumno("Paco", 22, new float[] {3, 4, 7, 8, 2});
		Alumno al5=new Alumno("Estefano", 30, new float[] {9, 0, 10, 3, 0});
		ArrayList <Alumno> alumnos=new ArrayList <Alumno>();
		alumnos.add(al1);
		alumnos.add(al2);
		alumnos.add(al3);
		alumnos.add(al4);
		GestionAlumnos gest= new GestionAlumnos("Alumnos.obj");
		gest.cargarAlumnos(alumnos);
		gest.verFicheroAlumnos();
		gest.aniadirAlumno(al5);
		System.out.println();
		gest.verFicheroAlumnos();
		System.out.println();
		/*GestionAlumnos gest1=new GestionAlumnos("Alumnosarraylist");
		gest1.cargarArrrayList(alumnos);
		gest1.verArrayList();*/
		gest.crearFichMas20("Mas20");
		gest.verfich("Mas20");
	}
}
