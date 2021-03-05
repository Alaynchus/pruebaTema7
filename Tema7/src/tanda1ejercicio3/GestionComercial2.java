package tanda1ejercicio3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class GestionComercial2 {
String nomfich;
	
	public GestionComercial2(String nomf) {
		nomfich=nomf;
	}
	public void guardaComerciales(ArrayList <Comercial> arrlist) throws IOException {
		//Hace falta poner el null?
		FileOutputStream fos= new FileOutputStream(nomfich);
		ObjectOutputStream oss= new ObjectOutputStream(fos);
		oss.writeObject(arrlist);
		oss.writeObject(null);
		oss.close();
	}
	public void buscaComercial(String nomComer) throws ClassNotFoundException, IOException {
		boolean yaleidouno=false;
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		ArrayList <Comercial> arrl=(ArrayList <Comercial>) ois.readObject();
		Comercial com;
		//El boolean es para que ponga mas de uno si se llaman igual
		while(arrl!=null && yaleidouno==false) {
			Iterator <Comercial> it=arrl.iterator();
			while(it.hasNext()) {
				com=it.next();
				if(com.getNombre().equals(nomComer)){
					System.out.println(com);
					yaleidouno=true;
				}
			}
			arrl=(ArrayList <Comercial>) ois.readObject();
		}
		if(yaleidouno==false) {
			System.err.println("No se ha podidio encontrar a "+nomComer);
		}
		System.out.println();
		ois.close();
	}
	public void generaFichMoviles(String nomfichmoviles) throws IOException, ClassNotFoundException {
		//Que es lo de cargar su saldo a 10
		FileOutputStream fos= new FileOutputStream(nomfichmoviles);
		ObjectOutputStream oss= new ObjectOutputStream(fos);
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Comercial com;
		ArrayList <Comercial> arrl=(ArrayList <Comercial>) ois.readObject();
		while(arrl!=null) {
			Iterator <Comercial> it=arrl.iterator();
			while(it.hasNext()) {
				com=it.next();
				if(com.getTelefono()!=null) {
					oss.writeObject(com.getTelefono());
				}
			}
			arrl=(ArrayList <Comercial>) ois.readObject();
		}
		oss.writeObject(null);
		oss.close();
		ois.close();
	}
	public void trabajarTodos() throws IOException, ClassNotFoundException {
		//Error raro
		FileOutputStream fos= new FileOutputStream(nomfich);
		ObjectOutputStream oss= new ObjectOutputStream(fos);
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Comercial com=(Comercial) ois.readObject();
		ArrayList <Comercial> arrli=new ArrayList <Comercial>();
		while(com!=null) {
			com.trabajar();
			arrli.add(com);
			com=(Comercial) ois.readObject();
		}
		Iterator <Comercial> it=arrli.iterator();
		while(it.hasNext()) {
			oss.writeObject(it.next());
		}
		oss.writeObject(null);
		oss.close();
		ois.close();
	}
	public void verComerciales() throws IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		ArrayList <Comercial> arrl=(ArrayList <Comercial>) ois.readObject();
		while(arrl!=null) {
			Iterator <Comercial> it=arrl.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			 arrl=(ArrayList <Comercial>) ois.readObject();
		}
		System.out.println();
		ois.close();
	}
	public void verTelefonos(String nomfichero) throws IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream(nomfichero);
		ObjectInputStream ois=new ObjectInputStream(fis);
		TelefonoMovil tlf=(TelefonoMovil) ois.readObject();
		while(tlf!=null) {
			tlf.ver();
			tlf=(TelefonoMovil) ois.readObject();
		}
		System.out.println();
		ois.close();
	}
	public static void main(String[] args) throws  ClassNotFoundException, IOException {
		GestionComercial gc1=new GestionComercial("comerciales.obj");
		ArrayList <Comercial> arrlist1=new ArrayList<Comercial>();
		arrlist1.add(new Comercial("Igor", 200,(new TelefonoMovil(945654253, 650))));
		arrlist1.add(new Comercial("Unai", 350,(new TelefonoMovil(608295774, 981))));
		arrlist1.add(new Comercial("Iñaki", 100));
		arrlist1.add(new Comercial("Maria", 150));
		arrlist1.add(new Comercial("Alayn", 300));
		gc1.guardaComerciales(arrlist1);
		gc1.verComerciales();
		gc1.buscaComercial("Alayn");
		gc1.buscaComercial("Uxue");
		gc1.generaFichMoviles("MovileconArrl");
		gc1.verTelefonos("MovileconArrl");
	}
}
