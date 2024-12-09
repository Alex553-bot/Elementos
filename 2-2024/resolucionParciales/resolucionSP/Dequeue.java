public class Dequeue<T>{
	Node<T> top; 
	Node<T> last; 
	public Dequeue() {
		top = last = null; 
	}
	public void addF(T data) {
		Node nuevo = new Node(data); 
		if (top==null) {
			last = top = nuevo; 
		} else {			
			nuevo.next = top; 
			top.prev = nuevo;
			top = top.prev;
		}
	}
	public void add(T data) {
		Node nuevo = new Node(data); 
		if (top==null) {
			last = top = nuevo;
		} else {			
			last.next = nuevo;
			nuevo.prev = last;
			last = last.next; 
		}
	}
	public boolean empty() {
		return last == null;
	}
	public T pop() {
		T data = last.data;
		last = last.prev;  
		return data;
	}
} 