package ejercicio5tanda3;

import java.util.HashSet;

public class Plato {
	private String nomplato;
	private HashSet <Ingrediente> setingre;
	
	public Plato(String nom, HashSet <Ingrediente> ingredientes){
		nomplato=nom;
		setingre=ingredientes;
	}
	
	@Override
	public String toString() {
		return "Plato [nombre del plato=" + nomplato + ", ingredientes=" + setingre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomplato == null) ? 0 : nomplato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plato other = (Plato) obj;
		if (nomplato == null) {
			if (other.nomplato != null)
				return false;
		} else if (!nomplato.equals(other.nomplato))
			return false;
		return true;
	}
	public String getNomplato() {
		return nomplato;
	}

	public HashSet<Ingrediente> getSetingre() {
		return setingre;
	}
	
}
