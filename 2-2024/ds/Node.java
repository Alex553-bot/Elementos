package ds;
public class Node<T> {
	T value; 
	Node next; // puntero o enlace
	public Node(T value) {
		this.value = value;
		next = null;
	}
}