public class NodoSE<T extends Comparable> {
	// representacion de lista abstracta. 
	T value; 
	NodoSE<T> next;

	public NodoSE(T value) {
		this.value = value;
		this.next = null; 
	}
}