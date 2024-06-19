public class NodoSE<T extends Comparable> {
	T value; 
	NodoSE<T> next;

	public NodoSE(T value) {
		this.value = value;
		this.next = this; 
	}
}
