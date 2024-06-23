public class NodoDE<T extends Comparable> implements Comparable
{
	public T value; 
	public NodoDE<T> prev; 
	public NodoDE<T> next; 
	public NodoDE(T value) {
		this.value = value;
		prev = next = null; 
	}

	public int compareTo(Object o) {
		NodoDE<T> b = (NodoDE)o; 
		int r = this.value.compareTo(b.value);
		if (r<0) return -1; 
		return 0;
	}

	/**
	 * >0, 0, -1
	 * a.compareTo(o)
	 * b = o; 
	 * >0: a>b
	 * 0: a==b
	 * <0: a<b
	 */ 

}