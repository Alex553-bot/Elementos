package LDEC; 

public class Nodo<T extends Comparable> implements Comparable
{
	public T value; 
	public Nodo<T> prev; 
	public Nodo<T> next; 
	public Nodo(T value) {
		this.value = value;
		prev = this; 
		next = this;
	}

	public int compareTo(Object o) {
		Nodo<T> b = (Nodo)o; 
		int r = this.value.compareTo(b.value);
		if (r<=0) return -1; 
		return 0;
	}
}