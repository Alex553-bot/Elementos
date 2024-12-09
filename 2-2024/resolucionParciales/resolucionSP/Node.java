public class Node<T> {
	T data; 
	Node prev, next; 
	public Node(T data) {
		this.data = data;
		prev = next = null;
	}
}