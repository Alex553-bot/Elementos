package LDEC; 
public class Nodo<T extends Comparable> implements Comparable
{
	T dato; 
	Nodo next; 
	Nodo prev; 
	public Nodo(T dato) {
		this.dato = dato;
		next = prev = null; 
	}

	public int compareTo(Object otro) {
		Nodo n = (Nodo)otro;
		return dato.compareTo(n.dato);
	}
}