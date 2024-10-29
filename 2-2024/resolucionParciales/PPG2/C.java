import java.util.*; 
public class C {
	public boolean verificar(ArrayList<Verso> poema) {
		boolean cumple; 
		Verso str1; 
		if (poema.size()<=1) {
			cumple = true;
		} else {
			str1 = poema.get(0);
			poema.remove(0);
			cumple = str1.simetrico(poema.get(0))? verificar(poema): false;
			poema.add(0, str1);
		}
		return cumple;
	}

	class Verso {
		private ArrayList<String> palabras; 
		public Verso(ArrayList<String> palabras) {
			this.palabras = palabras;
		}
		public boolean simetrico(Verso otro) {
			boolean esSimetrico; 
			esSimetrico = palabras.get(palabras.size()-1).equals(otro.palabras.get(0));
			return esSimetrico; 
		}
	}
}
/**
 * a. ya esta completado
 * b. esta en el rango: 9 a 12 la parte recursiva
 * c. realiza un 'restore' al poema
 */