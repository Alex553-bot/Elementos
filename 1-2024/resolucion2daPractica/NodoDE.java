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

		return this.value.compareTo(b.value);
	}
}