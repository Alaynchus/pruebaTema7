package tanda1ejercicio3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class GestionComercial {
	String nomfich;
	
	public GestionComercial(String nomf) {
		nomfich=nomf;
	}
	public void guardaComerciales(ArrayList <Comercial> arrlist) throws IOException {
		FileOutputStream fos= new FileOutputStream(nomfich);
		ObjectOutputStream oss= new ObjectOutputStream(fos);
		Iterator <Comercial> it=arrlist.iterator();
		while(it.hasNext()) {
			oss.writeObject(it.next());
		}
		oss.writeObject(null);
		oss.close();
	}
	public void buscaComercial(String nomComer) throws ClassNotFoundException, IOException {
		boolean yaleidouno=false;
		FileInputStream fis= new FileInputStream(nomfich);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Comercial com=(Comercial) ois.readObject();
		//El boolean es para que ponga mas de uno si se llaman igual
		while(com!=null && yaleidouno==false) {
			if(com.getNombre().equals(nomComer)){
				com.ver();
				yaleidouno=true;
			}
			com=(Comercial) ois.readObject();
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
		Comercial com=(Comercial) ois.readObject();
		while(com!=null) {
			if(com.getTelefono()!=null) {
				oss.writeObject(com.getTelefono());
			}
			com=(Comercial) ois.readObject();
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
		Comercial com=(Comercial) ois.readObject();
		while(com!=null) {
			com.ver();
			com=(Comercial) ois.readObject();
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
		gc1.buscaComercial("Uxue");
		gc1.generaFichMoviles("Movile.obj");
		gc1.verTelefonos("Movile.obj"); 
		
		
	}
}
