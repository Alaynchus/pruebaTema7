package ejercicio5tanda3;

public class Ingrediente {
	private String nomingre;
	private int numcalorias;
	
	public Ingrediente(String nom, int num) {
		nomingre=nom;
		numcalorias=num;
	}

	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nomingre + ", numero de calorias=" + numcalorias + "]";
	}

	public String getNomingre() {
		return nomingre;
	}
	
	public int getNumcalorias() {
		return numcalorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomingre == null) ? 0 : nomingre.hashCode());
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
		Ingrediente other = (Ingrediente) obj;
		if (nomingre == null) {
			if (other.nomingre != null)
				return false;
		} else if (!nomingre.equals(other.nomingre))
			return false;
		return true;
	}
	
	
}
