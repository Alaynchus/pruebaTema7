package ejercicio5tanda3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import ejercicio4tanda3.Consola;


public class Cocinero {
	private ArrayList <Ingrediente> ingarr;
	private HashMap <String, Plato> maplato;
	private final int caloriasmax=249;
	
	public Cocinero(){
		ingarr=new ArrayList <Ingrediente>();
		maplato=new HashMap <String, Plato>();
	}
	public void aniadirIngrediente(Ingrediente ingre) {
		Iterator <Ingrediente> it=ingarr.iterator();
		Ingrediente in;
		String res="";
		while(it.hasNext()) {
			in=it.next();
			if(in.equals(ingre)) {
				System.out.println("El ingrediente "+ingre.getNomingre()+" ya existe desea cambiarlo? S/N");
				res=Consola.leeString();
				if(res.equals("S")) {
					ingarr.remove(ingre);
					ingarr.add(ingre);
					System.out.println("El ingrediente "+ingre.getNomingre()+" ha cambiado");
					return;
				}
				else {
					System.out.println("El ingrediente "+ingre.getNomingre()+" no ha cambiado");
					return;
				}
			}
		}
		System.out.println("El ingrediente "+ingre.getNomingre()+" se ha añadidio correctamente");
		ingarr.add(ingre);
	}
	public void aniadirIngrediente(Ingrediente[] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.aniadirIngrediente(arr[i]);
		}
	}
	public void aniadirPlato(Plato pla) {
		Iterator <String> it=maplato.keySet().iterator();
		String clave;
		while(it.hasNext()) {
			clave=it.next();
			if(clave.equals(pla.getNomplato())) {
				System.out.println("El plato "+pla.getNomplato()+" ya está añadido");
				return;
			}
		}		
		maplato.put(pla.getNomplato(), pla);
	}
	public void aniadirPlatoRandom(String nom, int numing) {
		if(maplato.containsKey(nom)) {
			System.out.println("Este plato ya existe");
			return;
		}
		
		if(ingarr.size()<numing) {
			System.out.println("No hay suficientes ingredientes");
			return;
		}
		else {
			if(ingarr.size()==numing) {
				HashSet <Ingrediente> setingre=new HashSet <Ingrediente>();
				Iterator <Ingrediente> it=ingarr.iterator();
				while(it.hasNext()) {
					setingre.add(it.next());
				}
				Plato p=new Plato(nom, setingre);
				aniadirPlato(p);
				System.out.println("Plato añadido correctamente");
				return;
			}
			else {
				ArrayList <Ingrediente> arringre=new ArrayList <Ingrediente>();
				HashSet <Ingrediente> setingre=new HashSet <Ingrediente>();
				Iterator <Ingrediente> it=ingarr.iterator();
				while(it.hasNext()) {
					arringre.add(it.next());
				}
				while(arringre.size()-numing>0) {
					int indice=(int)(Math.random()*arringre.size());
					arringre.remove(indice);
				}
				Iterator <Ingrediente> itarringre=arringre.iterator();
				Ingrediente ingre;
				while (itarringre.hasNext()) {
					ingre=itarringre.next();
					if(ingre!=null) {
						setingre.add(ingre);
					}
				}
				Plato p=new Plato(nom, setingre);
				aniadirPlato(p);
				System.out.println("Plato añadido correctamente");
				return;
			}
		}
	}
	public void verMapa(int numcalo) {
		Iterator <Plato> itplatos=maplato.values().iterator();
		HashSet <Ingrediente> ingredientes=new HashSet <Ingrediente>();
		Plato pla;
		Ingrediente ing;
		int caloriastot=0;
		while(itplatos.hasNext()) {
			caloriastot=0;
			pla=itplatos.next();
			ingredientes=pla.getSetingre();
			Iterator <Ingrediente> itingredientesplato=ingredientes.iterator();
			while(itingredientesplato.hasNext()) {
				ing=itingredientesplato.next();
				caloriastot+=ing.getNumcalorias();
			}
			if(caloriastot<=numcalo) {
				System.out.println(pla);
			}
		}
	}
	public void eliminarCalorias() {
		HashSet <Ingrediente> ingredientes=new HashSet <Ingrediente>();
		Iterator <Plato> itplatos=maplato.values().iterator();
		Plato pla;
		Ingrediente ing;
		while(itplatos.hasNext()) {
			pla=itplatos.next();
			ingredientes=pla.getSetingre();
			Iterator <Ingrediente> itingre=ingredientes.iterator();
			while(itingre.hasNext()) {
				ing=itingre.next();
				if(ing.getNumcalorias()>caloriasmax) {
					itingre.remove();
					System.out.println("El ingrediente "+ing.getNomingre()+" del plato "+pla.getNomplato()+" ha sido borrado");
				}
			}
		}
	}
	public void verIngrediente() {
		Iterator <Ingrediente> it=ingarr.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public void verPlatos() {
		Iterator <String> it=maplato.keySet().iterator();
		String clave;
		Plato pla;
		HashSet <Ingrediente> ingredientes=new HashSet <Ingrediente>();
		Ingrediente ing;
		while(it.hasNext()) {
			clave=it.next();
			System.out.println(maplato.get(clave));
		}
	}
	public static void main(String[] args) {
		Cocinero c1=new Cocinero();
		Ingrediente ingre1=new Ingrediente("Sal", 100);
		Ingrediente ingre2=new Ingrediente("Tomate", 200);
		Ingrediente ingre3=new Ingrediente("Azucar", 250);
		Ingrediente ingre4=new Ingrediente("Lechuga", 100);
		Ingrediente[] arr= {ingre2, ingre3};
		HashSet <Ingrediente> ingredientespla1=new HashSet <Ingrediente>();
		ingredientespla1.add(ingre1);
		ingredientespla1.add(ingre4);
		HashSet <Ingrediente> ingredientespla2=new HashSet <Ingrediente>();
		ingredientespla2.add(ingre2);
		Plato p1=new Plato("Pure", ingredientespla1);
		Plato p2=new Plato("Ensalada", ingredientespla2);
		c1.aniadirIngrediente(ingre1);
		c1.aniadirIngrediente(ingre2);
		c1.aniadirIngrediente(ingre3);
		c1.aniadirIngrediente(ingre4);
		c1.aniadirPlato(p1);
		c1.aniadirPlato(p2);
		c1.aniadirPlatoRandom("Lasaña", 3);
		c1.verPlatos();
		System.out.println();
		c1.verMapa(250);
		c1.eliminarCalorias();
		System.out.println();
		c1.verPlatos();
		
	}
}
