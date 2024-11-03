public class List {
	Node top ; 
	public List() {
		top = new Node(-100000);
	}
	public void add(int x) {
		Node nuevo = new Node(x); 
		nuevo.next = top.next;
		top.next = nuevo;
	}
	public int get(int i) {
		if (i<0 || i>=size()) return 0;
		return get(i, top.next);
	}
	private int get(int i, Node actual) {
		if (i==0) return actual.data;
		return get(i-1, actual.next);
	}
	public void erase(int x) {
		erase(x, top);
	}
	private void erase(int x, Node actual) {
		if (actual==null) return;
		erase(x, actual.next);
		if (actual.next!=null && actual.next.data == x) 
			actual.next = actual.next.next;
	}
	public int size() {
		return fsize(top.next);
		//return itsize();
	}
	private int fsize(Node actual) {
		if (actual==null) return 0;
		return 1+fsize(actual.next);
	}
	private int itsize() {
		int s = 0;
		for (Node actual = top.next; actual!=null; actual = actual.next, s++);
		return s;
	}
	public void print() {
		print(top.next);
	}
	private void print(Node actual) {
		if (actual==null) {System.out.println(); return;}
		System.out.print(actual.data+" ");
		print(actual.next);
	}
}